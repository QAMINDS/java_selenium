package Module4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.Login;
import saucelab.pages.Products;

public class TestProducts extends BaseTestMultiThread{

    private static final String URL = "https://www.saucedemo.com/";
    private static final int TIME_OUT = 5;

    @DataProvider (name = "validUserDataProvider")
    public Object [][] validUserDataProvider(){
        return new Object[][]{
                {"standard_user","secret_sauce"}
        };
    }

    @Test(dataProvider = "validUserDataProvider")
    public void testValidUser(String user, String password){
        Login login = new Login(this.getDriver(),TIME_OUT,URL);
        login.open();
        login.login(user,password);
        Products products = login.login(user,password);
        products.waitUntilLoaded();
        Assert.assertEquals(products.title(),"PRODUCTS");
        login.close();
    }

}
