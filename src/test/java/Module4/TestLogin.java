package Module4;

import common.BaseTestMultiThread;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.Login;


public class TestLogin extends BaseTestMultiThread {

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
        Login page = new Login(this.getDriver(),10,"https://www.saucedemo.com/");
        page.open();
        page.waitUntilLoaded();
        page.login(user,password);
        page.close();
    }
}
