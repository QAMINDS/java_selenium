package module4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.SauceLogin;
import saucelab.pages.SauceProducts;

public class TestLogin extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private static final int TIME_OUT = 10;
    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";

    @DataProvider(name = "validUsersDataProvider")
    public Object[][] validUsersDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }


    @DataProvider(name = "invalidUsersDataProvider")
    public Object[][] invalidUsersDataProvider() {
        return new Object[][]{
                {"invalid 1", "fdsadfsa"},
                {"invalid 2", "secret_sauce"},
                {"PROBLEM _USER", "SECRET_SAUCE"}
        };
    }


    @Test(dataProvider = "validUsersDataProvider", groups = {"sanity", "login"})
    public void testValidUser(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        Assert.assertEquals(login.getCurrentUrl(), INVENTORY_URL);
        login.close();
    }

    @Test(dataProvider = "invalidUsersDataProvider", groups = {"sanity", "login"})
    public void testInvalidUser(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        login.login(username, password);
        Assert.assertFalse(login.isValidUser());
        login.close();
    }


    @Test(dataProvider = "validUsersDataProvider", groups = {"sanity", "login"})
    public void testLogout(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.logout();
        login.waitUntilLoaded();
        Assert.assertEquals(login.getCurrentUrl(), URL);
    }

}
