package saucelad.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryListElements extends BaseElement {
    private final static By ITEMS = By.className("inventory_item");

    public InventoryListElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public List<WebElement> getItems() {
        return this.waitForElements(ITEMS);
    }
}