package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsElements extends BaseElement {

    private final static By TITLE = By.xpath("//span[@class='title']");

    private  final static  By FILTER = By.xpath("//*[@data-test='product_sort_container']");

    private  final static  By MENU = By.id("react-burger-menu-btn");

    private  final static  By ALL_ITEMS = By.id("inventory_sidebar_link");

    private final static By CART = By.id("shopping_cart_link");

    private final static By ITEM = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");



    public ProductsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getTitle() {
        return this.waitUntilClickable(TITLE);
    }

    public WebElement getFilter() {
        return this.waitUntilClickable(FILTER);
    }

    public WebElement getMenu() {
        return this.waitUntilClickable(MENU);
    }

    public WebElement getAllItems() {
        return this.waitUntilClickable(ALL_ITEMS);
    }

    public  WebElement getCart() { return  this.waitUntilClickable(CART); }

    public  WebElement getItem() { return  this.waitUntilClickable(ITEM); }

}
