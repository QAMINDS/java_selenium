package modulo4;

import common.BaseTest;
import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.Login;

public class TestLoginSauceLab extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com";
    private static final int TIME_OUT = 10;

    @DataProvider(name = "validUserDataProvider")
    public Object [][] validUsersDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
        };
    }

    @Test(dataProvider = "validUserDataProvider", groups = {"sanity","login"})
    public void testValidarUser(String user, String password){
            Login page = new Login(this.getDriver(),TIME_OUT,URL);
        page.open();
        page.waitUntilLoaded();
        page.login(user,password);
        Assert.assertTrue(page.isValidUser());
        page.close();
    }

    @DataProvider(name = "invalidUserDataProvider")
    public Object [][] invalidUsersDataProvider() {
        return new Object[][]{
                {"invalid1", "secret_sauce"},
                {"invalid2", "secret_sauce"},
        };
    }

    @Test (dataProvider= "invalidUserDataProvider", groups = {"sanity","login"})
    public void testInvalidUser(String user, String password) {
        Login page = new Login(this.getDriver(),TIME_OUT,URL);
        page.open();
        page.waitUntilLoaded();
        page.login(user,password);
        Assert.assertTrue(page.isValidUser());
        page.close();
    }

    @DataProvider(name = "userEmptyDataProvider")
    public Object [][] userAndPassEmptyDataProvider() {
        return new Object[][]{
                {"", "secret_sauce"},
        };
    }

    @Test  (dataProvider= "userEmptyDataProvider", groups = {"sanity","login"})
    public void testLoginUserEmpty(String user, String password){
        Login page = new Login(this.getDriver(),TIME_OUT,URL);
        page.open();
        page.waitUntilLoaded();
        page.login(user,password);
        System.out.println("TEXTO "+page.elements.getErrorMsg().getText());
        Assert.assertTrue(page.elements.getErrorMsg().getText().equals("Epic sadface: Username is required"));
        page.close();
    }

}
