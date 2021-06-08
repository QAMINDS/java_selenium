package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsElements extends BaseElement {

    private final static By B_T_P = By.id("back-to-products");

    private final static By ADD_TO_CART = By.id("add-to-cart-sauce-labs-backpack");

    private final static By PRODUCT_NAME = By.xpath("//div[@class='inventory_details_name large_size']");

    public ProductDetailsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getBTP() {
        return this.waitUntilClickable(B_T_P);
    }

    public WebElement getAddToCart() {
        return this.waitUntilClickable(ADD_TO_CART);
    }

    public WebElement getProductName() {
        return this.waitUntilClickable(PRODUCT_NAME);
    }
}
