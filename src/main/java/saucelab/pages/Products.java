package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.elements.LoginElements;
import saucelab.elements.ProductsElements;

public class Products extends BasePage {
    public ProductsElements elements;

    public Products(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
        this.elements = new ProductsElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getTitle();
        this.elements.getFilter();
    }
}
