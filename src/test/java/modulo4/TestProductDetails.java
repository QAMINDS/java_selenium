package modulo4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelab.components.InventoryItem;
import saucelab.pages.Login;
import saucelab.pages.ProductDetail;
import saucelab.pages.Producto;

public class TestProductDetails extends BaseTestMultiThread {
    private static final String URL = "https://www.saucedemo.com/";
    private static final int TIME_OUT = 10;

    @Test
    public void testDetailProducts() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Producto productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();

        //obtener el detall de cada producto
        for(InventoryItem item: productPage.inventoryList) {
           ProductDetail productDetailPage = item.consultDetail();
            productDetailPage.backToProducts();
        }



    }
}
