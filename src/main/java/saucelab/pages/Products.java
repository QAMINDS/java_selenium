package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.elements.ProductsElements;

import java.security.PublicKey;

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
        this.elements.getMenu();
        this.elements.getAllItems();
        this.elements.getCart();
    }

    public String title(){
        String title = this.elements.getTitle().getText();
        return  title;
    }
}
