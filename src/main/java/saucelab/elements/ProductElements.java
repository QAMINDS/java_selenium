package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductElements extends BaseElement {

    private final static By SELECT = By.xpath("//*[@data-test='product_sort_container']");

    private final static By TITLE = By.className("title");


    public ProductElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getSelect() {
        return this.waitUntilClickable(SELECT);
    }

    public WebElement getTitle() {
        return this.waitUntilVisible(TITLE);
    }




}
