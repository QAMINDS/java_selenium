package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucelab.elements.CartElements;

import java.util.ArrayList;
import java.util.List;

public class YourCart extends BasePage {

    public CartElements elements;
    private int j;

    public YourCart(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new CartElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getContShopBtn();
        this.elements.getCartProdName();
        this.elements.getCartProdButton();
    }

    public String cartProdName() {
        logger.info("Checking product name in Your Cart");
        String cartProdName = this.elements.getCartProdName().getText();
        logger.info("Product name is :" + cartProdName);
        return cartProdName;
    }

    public void removeCartProdFromCart() {
        logger.info("Removing product from Cart");
        this.elements.getCartProdButton().click();
    }

    public void continueShopping() {
        this.elements.getContShopBtn().click();
    }

    public int getProdCountCart() {
        List<WebElement> products = new ArrayList<>(this.elements.getNamesInCart());
        j= products.size();
        return j;
    }

}
