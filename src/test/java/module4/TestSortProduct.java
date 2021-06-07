package module4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.Login;
import saucelab.pages.Product;


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


        for (var item : productPage.inventoryList) {


            System.out.println("--------------------");
            System.out.println(item.getTitle());
            System.out.println(item.getDescription());
            System.out.println(item.getPrice());
            System.out.println();
            item.addToCart();
        }
    }
}
