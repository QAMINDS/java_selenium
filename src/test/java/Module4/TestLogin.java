package Module4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.Login;
import saucelab.pages.Products;


public class TestLogin extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private static final int TIME_OUT = 5;
    private static final String URL_INVENTORI = "https://www.saucedemo.com/inventory";

    @DataProvider (name = "validUserDataProvider")
    public Object [][] validUserDataProvider(){
        return new Object[][]{
                {"standard_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"}
        };
    }

    @Test(dataProvider = "validUserDataProvider")
    public void testValidUser(String user, String password){
        Login page = new Login(this.getDriver(),TIME_OUT,URL);
        page.open();
        page.waitUntilLoaded();
        page.login(user,password);
        page.close();
    }

    @Test
    public void testInvalidUser(){
        Login page = new Login(this.getDriver(),TIME_OUT,URL);
        page.open();
        page.waitUntilLoaded();
        page.login("standard_user","123");
        Assert.assertTrue(page.isInvalidUser());
        page.close();
    }
}
