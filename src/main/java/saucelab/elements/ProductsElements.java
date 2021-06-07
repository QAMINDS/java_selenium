package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsElements extends BaseElement {

    private final static By TITLE = By.xpath("//span[@class='title']");

    private  final static  By FILTER = By.xpath("//*[@data-test='product_sort_container']");

    public ProductsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getTitle() {
        return this.waitUntilClickable(TITLE);
    }

    public WebElement getFilter() {
        return this.waitUntilClickable(FILTER);
    }

}
