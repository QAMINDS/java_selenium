package module4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.components.InventoryItem;
import saucelab.pages.SauceLogin;
import saucelab.pages.SauceProducts;
import saucelab.pages.Saucelabs;
import twitter.pages.TwitterSaucelabs;

public class TestProducts extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private static final String SAUCE_URL = "https://saucelabs.com/";
    private static final String TWTTER_URL = "https://twitter.com/saucelabs";
    private static final String PRODUCTS_TITLE = "PRODUCTS";
    private static final int INITIAL_BADGE = 0;
    private static final int TIME_OUT = 10;


    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }


    @DataProvider(name = "sortDataProvider")
    public Object[][] sortDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce", SauceProducts.SortOption.HILO},
                {"standard_user", "secret_sauce", SauceProducts.SortOption.AZ},
                {"standard_user", "secret_sauce", SauceProducts.SortOption.ZA},
                {"standard_user", "secret_sauce", SauceProducts.SortOption.LOHI},
        };
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testTitle(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        Assert.assertEquals(productsPage.title(), PRODUCTS_TITLE);
    }


    @Test(enabled = false, dataProvider = "sortDataProvider", groups = {"product"})
    public void testSortProducts(String username, String password, SauceProducts.SortOption option) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.sort(option);
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testSortHILO(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.sort(SauceProducts.SortOption.HILO);
        for (var item : productsPage.inventoryList) {
        }
        Assert.assertEquals(productsPage.inventoryList.currentPrices, productsPage.inventoryList.pricesHitoLo());
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testSortAZ(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.sort(SauceProducts.SortOption.AZ);
        for (var item : productsPage.inventoryList) {
        }
        Assert.assertEquals(productsPage.inventoryList.currentNames, productsPage.inventoryList.namesAtoZ());
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testSortZA(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.sort(SauceProducts.SortOption.ZA);
        for (var item : productsPage.inventoryList) {
        }
        Assert.assertEquals(productsPage.inventoryList.currentNames, productsPage.inventoryList.namesZtoA());
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testSortLOHI(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.sort(SauceProducts.SortOption.LOHI);
        for (var item : productsPage.inventoryList) {
        }
        Assert.assertEquals(productsPage.inventoryList.currentPrices, productsPage.inventoryList.pricesLotoHi());
    }


    @Test(dataProvider = "loginDataProvider", groups = {"sanity", "login"})
    public void testLogout(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.logout();
        login.waitUntilLoaded();
        Assert.assertEquals(login.getCurrentUrl(), URL);
    }


    @Test(dataProvider = "loginDataProvider", groups = {"sanity"})
    public void testAboutLink(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.selectAbout();
        Saucelabs saucelabs = new Saucelabs(this.getDriver(), TIME_OUT);
        saucelabs.waitUntilLoaded();
        Assert.assertEquals(saucelabs.getCurrentUrl(), SAUCE_URL);
    }


    @Test(dataProvider = "loginDataProvider", groups = {"sanity"})
    public void testTwitterLink(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        productsPage.goToTwitter();
        TwitterSaucelabs twitter = new TwitterSaucelabs(this.getDriver(), TIME_OUT);
        twitter.waitUntilLoaded();
        Assert.assertEquals(twitter.getCurrentUrl(), TWTTER_URL);
        //System.out.println("Currently on: " + twitter.getCurrentUrl());
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testBadgeInitial(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        Assert.assertEquals(productsPage.badgeNumber(), INITIAL_BADGE);
    }


    @Test(dataProvider = "loginDataProvider", groups = {"product"})
    public void testRandomAddRemove(String username, String password) {
        SauceLogin login = new SauceLogin(this.getDriver(), TIME_OUT, URL);
        login.open();
        login.waitUntilLoaded();
        SauceProducts productsPage = login.login(username, password);
        Assert.assertTrue(login.isValidUser());
        productsPage.waitUntilLoaded();
        InventoryItem item = productsPage.inventoryList.randomItem();
        item.addToCart();
        Assert.assertTrue(item.isInCart());
        Assert.assertEquals(productsPage.badgeNumber(), INITIAL_BADGE + 1);
        item.removeFromCart();
        Assert.assertFalse(item.isInCart());
        Assert.assertEquals(productsPage.badgeNumber(), INITIAL_BADGE);
    }

}
