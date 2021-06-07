package saucelad.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
//import saucelab.components.InventoryList;
import saucelad.components.InventoryItem;
import saucelad.components.InventoryList;
import saucelad.elements.ProductElements;
//import

public class Product extends BasePage {

    public ProductElements elements;
   //public InventoryList inventoryList;
    public InventoryItem inventoryItem;

    public enum SortOption {
        AZ,
        ZA,
        LOHI,
        HILO,
    }

    public Product(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProductElements(driver, timeout);
        InventoryList inventoryList = new InventoryList(driver, timeout);
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