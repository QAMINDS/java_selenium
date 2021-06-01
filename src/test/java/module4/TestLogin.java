package module4;

import common.BaseTestMultiThread;
import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.SauceLogin;

public class TestLogin extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private static final int TIME_OUT = 10;



    @Test(groups = {"sanity"})
    public void testValidUser(){
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(login.isValidUser());
        login.close();
    }

    @Test(groups = {"sanity"})
    public void testInvalidUser(){
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        login.login("invalid_user", "secret_sauce");
        Assert.assertFalse(login.isValidUser());
        login.close();
    }
}
