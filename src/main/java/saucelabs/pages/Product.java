package saucelabs.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import saucelabs.elements.InventoryListElements;
import saucelabs.elements.ProductElements;
import saucelabs.elements.ProductElementsKotlin;
//import saucelab.components.InventoryList;
//import saucelab.elements.ProductElements;

public class Product extends BasePage {
    public ProductElements elements;
    public InventoryListElements inventoryList;

    public enum SortOption {
        AZ,
        ZA,
        LOHI,
        HILO,
    }

    public Product(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProductElements(driver, timeout);
        inventoryList = new InventoryListElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getSelect();
        this.elements.getTitle();
    }

    public void sort(SortOption option) {
        Select select = new Select(this.elements.getSelect());
        select.selectByValue(option.name().toLowerCase());
    }
}
