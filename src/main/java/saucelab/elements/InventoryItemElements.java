package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryItemElements extends BaseElement {

    private final static By NAME= By.xpath(".//*[@class='inventory_item_name']");

    private final static By DESCRIPTION= By.xpath(".//*[@class='inventory_item_desc']");

    private final static By PRICE = By.xpath(".//*[@class='inventory_item_price']");

    private final static By BUTTON = By.xpath(".//button[contains(@class, 'btn_inventory')]");

    public InventoryItemElements(WebDriver driver, int timeout, WebElement rootElement) {
        super(driver, timeout, rootElement);
    }

    public InventoryItemElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getName() {
        return this.waitUntilSubElementClickable(NAME);
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

    public List<WebElement> getLink() {
        return this.waitForElements(NAME);
    }

    public List<WebElement> getAllButtons() {
        return this.waitForElements(BUTTON);
    }
}