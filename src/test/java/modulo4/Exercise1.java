package modulo4;

import common.BaseTest;
import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelad.pages.Saucelad;

public class Exercise1 extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private  static final int TIME_OUT = 10;

    @DataProvider(name = "validUsersDataProvider")
    public Object [][] validUsersDataProvider () {
        return  new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "validUsersDataProvider", groups = {"sanity","login"} )
    public void  testValidUser(String user, String password){
        Saucelad loginPage = new Saucelad(this.getDriver(),TIME_OUT,URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login(user,password);
        Assert.assertTrue(loginPage.IsValidUser());
    }



}
