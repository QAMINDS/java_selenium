package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.elements.ProductDetailsElements;

public class ProductDetails extends BasePage {
    public ProductDetailsElements elements;

    public ProductDetails(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
        this.elements = new ProductDetailsElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getBTP();
        this.elements.getAddToCart();
        this.elements.getProductName();
    }

}
