package module1.lessons.saucelabs;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelabs.pages.Login;
import saucelabs.pages.Product;

public class TestSortProduct extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @DataProvider(name = "sortDataProvider")
    public Object[][] sortDataProvider() {
        return new Object [][] {
                {"standard_user", "secret_sauce", Product.SortOption.HILO},
                {"standard_user", "secret_sauce", Product.SortOption.AZ},
                {"standard_user", "secret_sauce", Product.SortOption.ZA},
                {"standard_user", "secret_sauce", Product.SortOption.LOHI},
        };
    }

    @Test(dataProvider = "sortDataProvider", groups = {"product"})
    public void testSortProducts(String user, String password, Product.SortOption option) {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login(user, password);
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(option);
    }
}