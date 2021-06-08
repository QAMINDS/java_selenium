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

    @DataProvider(name = "sortDataProvider")
    public Object[][] sortDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce", Products.SortOption.HILO},
                {"standard_user", "secret_sauce", Products.SortOption.AZ},
                {"standard_user", "secret_sauce", Products.SortOption.ZA},
                {"standard_user", "secret_sauce", Products.SortOption.LOHI},
        };
    }

    @Test (description = "Sort By price" , groups = {"functional", "regression"})
    public void testAmountItemsByPrice(){
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Products productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Products.SortOption.LOHI);
        Assert.assertTrue(productPage.getItem());

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

    @Test(dataProvider = "validUserDataProvider")
    public void testMenu(String user, String password){
        Login login = new Login(this.getDriver(),TIME_OUT,URL);
        login.open();
        login.waitUntilLoaded();
        Products products = login.login("standard_user","secret_sauce");
        products.waitUntilLoaded();
        products.menu();
    }

}
