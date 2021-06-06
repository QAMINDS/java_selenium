package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartElements extends BaseElement {

    private final static By CONT_SHOP_BTN = By.id("continue-shopping");

    private final static By CART_PROD_NAME = By.className("inventory_item_name");

    private final static By CART_PROD_BUTTON = By.xpath("//button[contains(@class, 'cart_button')]");

    public CartElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getContShopBtn() {
        return this.waitUntilClickable(CONT_SHOP_BTN);
    }

    public WebElement getCartProdName() {
        return this.waitUntilVisible(CART_PROD_NAME);
    }

    public WebElement getCartProdButton() {
        return this.waitUntilClickable(CART_PROD_BUTTON);
    }

    public List<WebElement> getNamesInCart() {
        return this.dontWaitForElements(CART_PROD_NAME);
    }

}
