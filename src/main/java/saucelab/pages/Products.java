package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import saucelab.elements.ProductsElements;

import java.security.PublicKey;
import java.util.List;

public class Products extends BasePage {
    public ProductsElements elements;
    public Object inventoryList;

    public Products(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
        this.elements = new ProductsElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getTitle();
        this.elements.getFilter();
        this.elements.getMenu();
        this.elements.getAllItems();
        this.elements.getCart();
        this.elements.getItem();
    }

    public enum SortOption {
        AZ,
        ZA,
        LOHI,
        HILO,
    }

    public void sort(SortOption option) {
        Select select = new Select(this.elements.getFilter());
        select.selectByValue(option.name().toLowerCase());
        logger.info("Sorting by: " + option.name());
    }


    public String title(){
        String title = this.elements.getTitle().getText();
        return  title;
    }

    public void menu(){
        this.elements.getMenu().click();
    }

    public boolean getItem() {

        List<WebElement> results = this.getDriver().findElements(By.xpath(".//*[@class='inventory_item']"));
        if (results.size() == 6);
        return true;
    }

    public void clickItem(){
        this.elements.getItem().click();
    }
}
