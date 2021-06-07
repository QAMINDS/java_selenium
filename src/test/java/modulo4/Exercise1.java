package modulo4;

//import common.BaseTest;
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
    @DataProvider(name = "invalidUser")
    public Object [][] invalidUser () {
        return  new Object[][]{
                {"standard_user", ""}

        };
    }

    @DataProvider(name = "invalidPass")
    public Object [][] invalidPass () {
        return  new Object[][]{
                {"", "secret_sauce"}

        };
    }

    @Test(dataProvider = "validUsersDataProvider", groups = {"sanity","login"} )
    public void  testValidUser(String user, String password){
        Saucelad loginPage = new Saucelad(this.getDriver(),TIME_OUT,URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login(user,password);
        Assert.assertTrue(loginPage.IsValidUser());
        loginPage.close();
    }
    @Test
     public void testInvalidUser(){
        Saucelad loginPage = new Saucelad(this.getDriver(),TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login("ivalid","invalida");
        Assert.assertTrue(loginPage.IsValidUser());
        //System.clearProperty("");
        loginPage.close();

    }
    //#1
    @Test
    public void tesCamposVacios() {
        Saucelad loginPage = new Saucelad(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.loginVacio();
        Assert.assertTrue(loginPage.IsValidUser());
        loginPage.close();
    }
    //#2
    @Test(dataProvider = "invalidUser",groups = {"sanity","login"},description="escribir un usario correcto con contraseña invalida")
    public void testUsersinPass(String user, String password) {
        Saucelad loginPage = new Saucelad(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login(user,password);
        Assert.assertTrue(loginPage.IsValidUser());
        loginPage.close();
    }
    //#3
    @Test(dataProvider = "invalidPass",groups = {"sanity","login"},description="escribir password correcta con usario vacio")
    public void testPasssinUser(String user, String password) {
        Saucelad loginPage = new Saucelad(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        loginPage.login(user,password);
        Assert.assertTrue(loginPage.IsValidUser());
        loginPage.close();
    }

}
