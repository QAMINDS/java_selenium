package module1.lessons.saucelabs;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelabs.pages.InventoryItemPage;
import saucelabs.pages.Login;
import saucelabs.pages.Product;

public class TestInventoryItem extends BaseTestMultiThread {

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

        // Interact with product
        for(var item: productPage.inventoryList) {
            System.out.println("--------------------");
            System.out.println(item.getTitle());
            System.out.println(item.getDescription());
            System.out.println(item.getPrice());
            InventoryItemPage inventoryItemPage = item.clickOnPicture();
            System.out.println(inventoryItemPage.getItemDetailsName());
            System.out.println(inventoryItemPage.getItemDetailsDescription());
            System.out.println(inventoryItemPage.getItemDetailsPrice());
            inventoryItemPage.navigatePreviousPage();
        }
    }
}
