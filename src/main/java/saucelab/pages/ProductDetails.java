package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.elements.ProdDetailsElements;

public class ProductDetails extends BasePage {
    private static String REMOVE_LABEL = "remove";

    public ProdDetailsElements elements;

    public ProductDetails(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProdDetailsElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getBackButton();
        this.elements.getProdName();
        this.elements.getProdButton();
    }

    public String prodName() {
        logger.info("Checking product name in details page");
        String prodName = this.elements.getProdName().getText();
        logger.info("Product name is :" + prodName);
        return prodName;
    }

    public Boolean isProdInCart() {
        return (this.elements.getProdButton().getText().toLowerCase().equals(REMOVE_LABEL));
    }

    public void addProdToCart() {
        if (!this.isProdInCart()) {
            this.elements.getProdButton().click();
            logger.info("Adding product to Cart");
        }
    }

    public void removeProdFromCart() {
        if (this.isProdInCart()) {
            this.elements.getProdButton().click();
            logger.info("Removing product from Cart");
        }
    }

    public void returnToProducs() {
        this.elements.getBackButton().click();
    }

}
