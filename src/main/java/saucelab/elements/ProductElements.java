package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductElements extends BaseElement {

    private final static By SELECT = By.xpath("//*[@data-test='product_sort_container']");

    private final static By TITLE = By.className("title");

    private final static By BACK_TO_PRODUCTS = By.xpath("//button[normalize-space()='Back to products']");

    private final static By REMOVE = By.xpath(".//button[normalize-space()='Remove']");

    public ProductElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getSelect() {
        return this.waitUntilClickable(SELECT);
    }

    public WebElement getTitle() {
        return this.waitUntilVisible(TITLE);
    }

    public WebElement getDetailsTitle() {
        return this.waitUntilClickable(BACK_TO_PRODUCTS);
    }

    public WebElement isInCart(){
        return this.waitUntilClickable(REMOVE);
    }


    }

