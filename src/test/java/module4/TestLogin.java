package module4;

import common.BaseTest;
import common.BaseTestMultiThread;
import google.pages.Google;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.Login;

public class TestLogin extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private static final int TIME_OUT = 10;

    @DataProvider(name= "validUsersDataProvider")
    public Object[][] validUsersDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };

    }

    @DataProvider(name= "invalidUsersDataProvider")
    public Object[][] invalidUsersDataProvider() {
        return new Object[][]{
                {"invalid", "secret_sauce"},
                {" ", " "}

        };

    }

    @Test(dataProvider = "validUsersDataProvider",description = "Test Valid users" , groups = {"functional", "regression"})
    public void testValidUser(String user, String password) {
        Login loginPage = new Login(this.getDriver(), TIME_OUT,URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login(user,password);
        Assert.assertTrue(loginPage.isValidUser());
        loginPage.close();
    }

    @Test(dataProvider = "invalidUsersDataProvider",description = "Test Invalid users" , groups = {"functional", "regression"})
    public void testInvalidUser(String user, String password) {
        Login loginPage = new Login(this.getDriver(), TIME_OUT,URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login(user,password);
        Assert.assertFalse(loginPage.isValidUser());
        loginPage.close();
    }
}
