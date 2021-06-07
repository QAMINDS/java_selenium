package modulo4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucelad.pages.Product;
import saucelad.pages.Saucelad;
import saucelad.pages.Checkout;

public class checkout extends BaseTestMultiThread {

    private static final String URL = "https://www.saucedemo.com/";
    private static final int TIME_OUT = 10;

    @Test
    public void testCheckout() {
        Checkout checkoutPage = new Checkout(this.getDriver(), TIME_OUT, URL);
        checkoutPage.open();
        checkoutPage.waitUntilLoaded();
        checkoutPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(checkoutPage.IsValidUser());

        checkoutPage.waitUntilProduct();
        checkoutPage.selectProduct();

        checkoutPage.waitUntilCheckout();
        checkoutPage.checkout("noel","lope","1000");
        checkoutPage.waitUntilCheckout();

        checkoutPage.waitTitleCheckout();
        checkoutPage.close();



    }

}
