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

    @DataProvider(name = "titleDataProvider")
    public Object[][] titleDataProvider() {
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

    @Test(dataProvider = "titleDataProvider", groups = {"product"})
    public void testTitle(String username, String password, String title) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        Assert.assertEquals(productsPage.title(), title);
    }


    @Test(dataProvider = "sortDataProvider", groups = {"product"})
    public void testSortProducts(String username, String password, SauceProducts.SortOption option) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.sort(option);
    }
}
