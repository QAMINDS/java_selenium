package module4;

import common.BaseTestMultiThread;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;
import saucelab.pages.YourCart;
import saucelab.pages.SauceLogin;
import saucelab.pages.SauceProducts;
import saucelab.elements.InventoryItemElements;

import java.util.ArrayList;
import java.util.List;

public class TestYourCart extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    private static final String YOUR_CART_URL = "https://www.saucedemo.com/cart.html";
    private static final int TIME_OUT = 10;
    private static final int INITIAL_CART_BADGE = 0;


    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testAddRemove(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        InventoryItemElements elements = new InventoryItemElements(this.getDriver(), TIME_OUT);
        YourCart cart = new YourCart(this.getDriver(), TIME_OUT);

        List<WebElement> buttons = new ArrayList<>(elements.getAllButtons());
        int size = buttons.size();

        String currentProduct;

        for (int i = 0; i < size; i++) {
            List<WebElement> buttonsLoop = new ArrayList<>(elements.getAllButtons());
            List<WebElement> namesLoop = new ArrayList<>(elements.getLink());
            currentProduct = namesLoop.get(i).getText();
            System.out.println("Adding product to cart: " + currentProduct);
            buttonsLoop.get(i).click();
            Assert.assertEquals(productsPage.badgeNumber(), INITIAL_CART_BADGE + 1);
            productsPage.goToCart();
            cart.waitUntilLoaded();
            Assert.assertEquals(cart.getCurrentUrl(), YOUR_CART_URL);
            Assert.assertEquals(cart.cartProdName(), currentProduct);
            cart.removeCartProdFromCart();
            Assert.assertEquals(productsPage.badgeNumber(), INITIAL_CART_BADGE);
            Assert.assertEquals(cart.getProdCountCart(), INITIAL_CART_BADGE);
            cart.continueShopping();
            productsPage.waitUntilLoaded();
            Assert.assertEquals(productsPage.getCurrentUrl(), INVENTORY_URL);
        }
    }

}
