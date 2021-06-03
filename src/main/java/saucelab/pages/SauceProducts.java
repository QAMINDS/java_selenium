package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
//import saucelab.components.InventoryList;
import saucelab.elements.ProductsElements;

public class SauceProducts extends BasePage{
    public ProductsElements elements;
    //public InventoryList inventoryList;

    public enum SortOption {
        AZ,
        ZA,
        LOHI,
        HILO,
    }

    public SauceProducts(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProductsElements(driver, timeout);
        //inventoryList = new InventoryList(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getProductsHeader();
        this.elements.getSortDropdown();
    }

    public String header (){
        String header = this.elements.getProductsHeader().getText();
        return header;
    }

    public void sort(SortOption option) {
        Select select = new Select(this.elements.getSortDropdown());
        select.selectByValue(option.name().toLowerCase());
    }
}