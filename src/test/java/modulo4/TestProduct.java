package modulo4;

import common.BaseTestMultiThread;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelab.components.InventoryItem;
import saucelab.pages.Login;
import saucelab.pages.Producto;

public class TestProduct extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @Test
    public void testProductInfo() {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Producto productPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(Producto.SortOption.AZ);
        //Imprimir información de cada producto
        productPage.getInformationProducts();
    }
}
