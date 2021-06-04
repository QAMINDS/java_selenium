package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsElements extends BaseElement{

    private final static By PRODUCTS_TITLE = By.xpath("//*[@class='title' and contains(text(),'Products')]");

    private final static By SORT_DROP = By.xpath("//*[@data-test='product_sort_container']");

    public ProductsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getProductsTitle() {
        return this.waitUntilVisible(PRODUCTS_TITLE);
    }

    public WebElement getSortDropdown () {
        return this.waitUntilClickable(SORT_DROP);
    }
}
