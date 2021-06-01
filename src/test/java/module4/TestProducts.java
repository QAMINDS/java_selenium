package module4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.SauceLogin;
import saucelab.pages.SauceProducts;

public class TestProducts extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @DataProvider(name = "headerDataProvider")
    public Object[][] headerDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "PRODUCTS"}
        };
    }

    @DataProvider(name = "sortDataProvider")
    public Object[][] sortDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce", SauceProducts.SortOption.HILO},
                {"standard_user", "secret_sauce", SauceProducts.SortOption.AZ},
                {"standard_user", "secret_sauce", SauceProducts.SortOption.ZA},
                {"standard_user", "secret_sauce", SauceProducts.SortOption.LOHI},
        };
    }

    @Test(dataProvider = "headerDataProvider", groups = {"product"})
    public void testHeader(String user, String password, String header) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productPage = login.login(user, password);
        Assert.assertTrue(login.isValidUser());
        productPage.waitUntilLoaded();
        Assert.assertEquals(productPage.header(), header);
    }


    @Test(dataProvider = "sortDataProvider", groups = {"product"})
    public void testSortProducts(String user, String password, SauceProducts.SortOption option) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productPage = login.login(user, password);
        Assert.assertTrue(login.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(option);
    }
}
