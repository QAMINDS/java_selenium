package saucelab.pages;
import common.BasePage;

import org.openqa.selenium.WebDriver;
import saucelab.components.InventoryItem;
import saucelab.elements.ProductElements;


public class ProductDetails extends BasePage {
    public ProductElements elements;
    public InventoryItem components;

    public ProductDetails(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProductElements(driver, timeout);

    }

    public void waitUntilLoadedDetails() {
        this.elements.getDetailsTitle();


    }

    public boolean getCartStatus() {
        return (this.elements.isInCart() != null);
    }
}
