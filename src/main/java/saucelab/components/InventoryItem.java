package saucelab.components;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucelab.elements.InventoryItemElements;

public class InventoryItem extends BasePage {
    private static String ADD_LABEL = "add to cart";

    private static String REMOVE_LABEL = "remove";
    public InventoryItemElements elements;

    public InventoryItem(WebDriver driver, int timeout, WebElement rootElement) {
        super(driver, timeout);
        elements = new InventoryItemElements(driver, timeout, rootElement);
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

    public String getName() {
        return this.elements.getName().getText();
    }


    public String getDescription() {
        return this.elements.getDescription().getText();
    }


    public String getPriceText() {
        return this.elements.getPrice().getText();
    }

    public float getPriceNumber() {
        String priceText = this.elements.getPrice().getText();
        priceText = priceText.replaceAll("[$]", "");
        float i = Float.parseFloat(priceText);
        return i;
    }
}
