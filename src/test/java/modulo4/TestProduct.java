package modulo4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;

import saucelad.pages.Product;
import saucelad.pages.Saucelad;
//import saucelad.pages.Saucelad;

public class TestProduct extends BaseTestMultiThread {
    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @Test
    public void testProductInfo() {
        Saucelad loginPage = new   Saucelad(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.IsValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Product.SortOption.AZ);

        System.out.println(productPage.inventoryItem.getTitle());
        System.out.println(productPage.inventoryItem.getDescription());
        System.out.println(productPage.inventoryItem.getPrice());
       productPage.inventoryItem.addToCart();
       productPage.close();

       /* Interact with product
        //for(var item: productPage.inventoryList) {
            System.out.println("--------------------");
            System.out.println(item.getTitle());
            System.out.println(item.getDescription());
            System.out.println(item.getPrice());
            item.addToCart();
        //}*/
    }

    @Test(description="Selecionar la opcion de prpductos con precions bajos")
    public void testSortProductslh() {
        Saucelad loginPage = new  Saucelad (this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Product productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.IsValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Product.SortOption.LOHI);
        productPage.close();
    }

}

