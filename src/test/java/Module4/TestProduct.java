package Module4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelab.pages.Login;
import saucelab.pages.Products;
import saucelab.pages.ProductDetails;

import java.util.List;

public class TestProduct extends BaseTestMultiThread{
    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @Test
    public void testBackToProducts() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Products productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();

    }

    //Test to verify that you can go to Product Details page by clicking the product Image
    @Test
    public void testAddToCart() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Products productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();

    }


    @Test
    public void testProductName() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Products productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.clickItem();


    }
}
