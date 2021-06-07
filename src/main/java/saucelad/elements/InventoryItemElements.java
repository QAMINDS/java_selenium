package saucelad.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItemElements extends BaseElement {

    private final static By TITLE= By.xpath(".//*[@class='inventory_item_name']");

    private final static By DESCRIPTION= By.xpath(".//*[@class='inventory_item_desc']");

    private final static By PRICE= By.xpath(".//*[@class='inventory_item_price']");

    private final static By BUTTON = By.xpath(".//*[contains(@class, 'btn_inventory')]");

    public InventoryItemElements(WebDriver driver, int timeout, WebElement rootElement) {
        super(driver, timeout, rootElement);
    }

    public WebElement getTitle() {
        return this.waitUntilSubElementVisible(TITLE);
    }

    public WebElement getDescription() {
        return this.waitUntilSubElementVisible(DESCRIPTION);
    }

    public WebElement getPrice() {
        return this.waitUntilSubElementVisible(PRICE);
    }

    public WebElement getButton() {
        return this.waitUntilSubElementClickable(BUTTON);
    }
}

