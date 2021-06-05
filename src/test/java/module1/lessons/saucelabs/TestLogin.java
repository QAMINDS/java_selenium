package module1.lessons.saucelabs;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelabs.pages.Login;

public class TestLogin extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @DataProvider(name = "validUsersDataProvider")
    public Object[][] validUsersDataProvider() {
        return new Object [][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "validUsersDataProvider", groups = {"sanity", "login"})
    public void testValidUser(String user, String password) {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login(user, password);
        Assert.assertTrue(loginPage.isValidUser());
    }

    @DataProvider(name = "invalidUsersDataProvider")
    public Object[][] invalidUsersDataProvider() {
        return new Object [][] {
                {"invalid 1", "fdsadfsa"},
                {"invalid 2", "secret_sauce"},
        };
    }

    @Test(dataProvider = "invalidUsersDataProvider", groups = {"sanity", "login"})
    public void testInvalidUser(String user, String password) {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login(user, password);
        Assert.assertFalse(loginPage.isValidUser());
    }
}
