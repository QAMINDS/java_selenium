package saucelabs.components;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucelabs.elements.InventoryItemElements;
import saucelabs.pages.InventoryItemPage;

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

    public String getTitle() {
        return this.elements.getTitle().getText();
    }


    public String getDescription() {
        return this.elements.getDescription().getText();
    }

    public String getPrice() {
        return this.elements.getPrice().getText();
    }

    public WebElement getPicture() {
        return this.elements.getPicture();
    }

    public InventoryItemPage clickOnPicture() {
        getPicture().click();
        return new InventoryItemPage(this.getDriver(), this.getTimeout());
    }
}
