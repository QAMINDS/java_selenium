package module4;

import common.BaseTestMultiThread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelab.components.InventoryItem;
import saucelab.pages.Login;
import saucelab.pages.Product;
import saucelab.pages.ProductDetails;

import java.util.List;

public class TestProductDetails extends BaseTestMultiThread {
    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    //Test to verify that you can go to Product Details page by clicking the product Title
    @Test (description = "Test product details by Title" , groups = {"functional"})
    public void testProductDetailsTitle() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();

        for (var item : productPage.inventoryList) {
            item.goToDetails();
            break;
        }
        ProductDetails pd = new ProductDetails(this.getDriver(),TIME_OUT);
        pd.waitUntilLoadedDetails();
    }

    //Test to verify that you can go to Product Details page by clicking the product Image
    @Test  (description = "Test product details by image" , groups = {"functional"})
    public void testProductDetailsImage() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();

        for (var item : productPage.inventoryList) {
            item.goToDetailsImage();
            break;
        }
        ProductDetails pd = new ProductDetails(this.getDriver(),TIME_OUT);
        pd.waitUntilLoadedDetails();
    }

    //Test to verify that if you added to cart an item prom the main page, it remains the same in the details page
    @Test (description = "Test product details added to cart" , groups = {"functional", "regression"})
    public void testProductAddToCart() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();

        for (var item : productPage.inventoryList) {
            item.addToCart();
            item.goToDetailsImage();
            break;
        }
        ProductDetails pd = new ProductDetails(this.getDriver(),TIME_OUT);
        pd.waitUntilLoadedDetails();
        System.out.println(pd.getCartStatus());
        Assert.assertTrue(pd.getCartStatus());


    }

}