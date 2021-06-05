package module1.lessons.lesson052921;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelabs.pages.Login;
import saucelabs.pages.Product;


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
//        for(var item: productPage.inventoryList) {
//            System.out.println("--------------------");
//            System.out.println(item.getTitle());
//            System.out.println(item.getDescription());
//            System.out.println(item.getPrice());
//            item.addToCart();
//        }
    }
}
