package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import saucelab.components.InventoryList;
import saucelab.elements.ProductElements;

import java.util.ArrayList;
import java.util.List;

public class Product extends BasePage {
    public ProductElements elements;
    public InventoryList inventoryList;

    public enum SortOption {
        AZ,
        ZA,
        LOHI,
        HILO,
    }

    public Product(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProductElements(driver, timeout);
        inventoryList = new InventoryList(driver, timeout);
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


    public boolean getItem() {

        List<WebElement> results = this.getDriver().findElements(By.xpath(".//*[@class='inventory_item']"));
        if (results.size() == 6);
        return true;
    }


    public boolean sortByPrice() {
        ArrayList<WebElement> prices = new ArrayList<>(this.getDriver().findElements(By.xpath(".//*[@class='inventory_item_price']")));

        System.out.println(prices.get(0).getText());
        if (prices.get(0).getText() == "$7.99");
        return true;
    }

}