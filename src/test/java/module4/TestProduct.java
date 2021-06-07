package module4;

import common.BaseTestMultiThread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelab.pages.Login;
import saucelab.pages.Product;

import java.util.List;

public class TestProduct extends BaseTestMultiThread {
    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @Test (description = "Shows product information" , groups = {"functional", "regression"})
    public void testProductInfo() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Product.SortOption.AZ);

        // Interact with product
        for (var item : productPage.inventoryList) {

            System.out.println("--------------------");
            System.out.println(item.getTitle());
            System.out.println(item.getDescription());
            System.out.println(item.getPrice());
            System.out.println();
            item.addToCart();
        }
    }

    //Test to verify that after changing the Sort option to Name the amount of items displayed in the screen remains the same
    @Test (description = "Sort By name" , groups = {"functional", "regression"})
    public void testAmountItems(){
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Product.SortOption.AZ);
        Assert.assertTrue(productPage.getItem());
    }


    //Test to verify that after changing the Sort option to Price the amount of items displayed in the screen remains the same
    @Test (description = "Sort By price" , groups = {"functional", "regression"})
    public void testAmountItemsByPrice(){
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Product.SortOption.LOHI);
        Assert.assertTrue(productPage.getItem());

    }

    //Test to verify that when sorting by price LoHi the product placement is correct
    @Test (description = "Test sorting LoHi is correct" , groups = {"functional"})
    public void testSortByPriceLoHi(){
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Product.SortOption.LOHI);
        Assert.assertTrue(productPage.sortByPrice());
//This test is not working fine, the method sortByPrice is not doing correctly the comparison
    }
}