package module4;

import common.BaseTestMultiThread;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.ProductDetails;
import saucelab.pages.SauceLogin;
import saucelab.pages.SauceProducts;
import saucelab.elements.InventoryItemElements;

import java.util.ArrayList;
import java.util.List;

public class TestProductDetails extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    private static final String PROD_DETAILS_URL = "https:\\/\\/www\\.saucedemo\\.com\\/inventory-item\\.html\\?id=[0-9]";
    private static final int TIME_OUT = 10;
    private static final int INITIAL_PROD_BADGE = 0;
    //private static String currentProduct;


    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testProductNavigation(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        InventoryItemElements elements = new InventoryItemElements(this.getDriver(), TIME_OUT);
        ProductDetails detailsPage = new ProductDetails(this.getDriver(), TIME_OUT);

        List<WebElement> links = new ArrayList<>(elements.getLink());
        int size = links.size();

        String currentProduct;

        for (int i = 0; i < size; i++) {
            List<WebElement> linksLoop = new ArrayList<>(elements.getLink());
            currentProduct = linksLoop.get(i).getText();
            System.out.println("value of currentProduct = " + currentProduct);
            linksLoop.get(i).click();
            detailsPage.waitUntilLoaded();
            Assert.assertTrue(detailsPage.getCurrentUrl().matches(PROD_DETAILS_URL));
            Assert.assertEquals(detailsPage.prodName(), currentProduct);
            detailsPage.returnToProducs();
            productsPage.waitUntilLoaded();
            Assert.assertEquals(productsPage.getCurrentUrl(), INVENTORY_URL);
        }
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
        ProductDetails detailsPage = new ProductDetails(this.getDriver(), TIME_OUT);

        List<WebElement> links = new ArrayList<>(elements.getLink());
        int size = links.size();

        String currentProduct;

        for (int i = 0; i < size; i++) {
            List<WebElement> linksLoop = new ArrayList<>(elements.getLink());
            currentProduct = linksLoop.get(i).getText();
            linksLoop.get(i).click();
            detailsPage.waitUntilLoaded();
            detailsPage.addProdToCart();
            Assert.assertTrue(detailsPage.isProdInCart());
            Assert.assertEquals(productsPage.badgeNumber(), INITIAL_PROD_BADGE + 1);
            detailsPage.removeProdFromCart();
            Assert.assertFalse(detailsPage.isProdInCart());
            Assert.assertEquals(productsPage.badgeNumber(), INITIAL_PROD_BADGE);
            detailsPage.returnToProducs();
            productsPage.waitUntilLoaded();
        }
    }

}
