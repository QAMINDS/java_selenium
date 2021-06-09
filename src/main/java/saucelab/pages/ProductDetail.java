package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.elements.ProductDetailsElements;
import saucelab.elements.ProductElements;

public class ProductDetail extends BasePage {
    public ProductDetailsElements elements;
    private static String ADD_LABEL = "add to cart";
    private static String REMOVE_LABEL = "remove";

    public ProductDetail(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProductDetailsElements(driver,timeout);
    }

    public void addToCart() {
        if (!this.isInCart()) {
            this.elements.getButton().click();
        }
    }

    public void removeFromCart() {
        if (this.isInCart()) {
            this.elements.getButton().click();
        }
    }

    public Boolean isInCart() {
        return (this.elements.getButton().getText().toLowerCase().equals(REMOVE_LABEL));

    }

    public String getTitle() {
        return this.elements.getTitle().getText();
    }


    public String getDescription() {
        return this.elements.getDescription().getText();
    }

    public String getPrice() {
        return this.elements.getPrice().getText();
    }

    public void backToProducts(){
         this.elements.getBtnBackToProduct().click();
    }

}
