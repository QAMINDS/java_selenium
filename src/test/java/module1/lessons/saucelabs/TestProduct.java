package module1.lessons.saucelabs;


import common.BaseTestMultiThread;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelabs.elements.InventoryListElements;
import saucelabs.pages.Login;
import saucelabs.pages.Product;

import java.util.List;


public class TestProduct extends BaseTestMultiThread {
    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @Test
    public void testProductInfo() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Product.SortOption.AZ);

        // Interact with product
        for(var item: productPage.inventoryList) {
            System.out.println("--------------------");
            System.out.println(item.getTitle());
            System.out.println(item.getDescription());
            System.out.println(item.getPrice());
            item.addToCart();
        }
    }
}
