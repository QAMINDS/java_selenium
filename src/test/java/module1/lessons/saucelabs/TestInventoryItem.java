package module1.lessons.saucelabs;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelabs.components.InventoryItem;
import saucelabs.components.InventoryList;
import saucelabs.pages.InventoryItemPage;
import saucelabs.pages.Login;
import saucelabs.pages.Product;

import java.util.Iterator;

public class TestInventoryItem extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @Test
    public void testProductInfo() throws InterruptedException {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();


        Iterator<InventoryItem> inventoryItemList = productPage.inventoryList.iterator();

//        for (int k=0; k<inventoryItemList.length(); k++) {
//            inventoryItemList.iterator().
//        }

        while (inventoryItemList.hasNext()) {
            InventoryItem inventoryItem = inventoryItemList.next();

            System.out.println(inventoryItem.getTitle());
            System.out.println(inventoryItem.getDescription());
            System.out.println(inventoryItem.getPrice());
            InventoryItemPage inventoryItemPage = inventoryItem.clickOnPicture();
            System.out.println(inventoryItemPage.getItemDetailsName());
            System.out.println(inventoryItemPage.getItemDetailsDescription());
            System.out.println(inventoryItemPage.getItemDetailsPrice());
            inventoryItemPage.navigatePreviousPage();
        }

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
