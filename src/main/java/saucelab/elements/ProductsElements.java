package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsElements extends BaseElement{

    private final static By PRODUCTS_HEADER = By.xpath("//*[@class='title' and contains(text(),'Products')]");

    private final static By SORT_DROP = By.xpath("//*[@data-test='product_sort_container']");

    public ProductsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getProductsHeader() {
        return this.waitUntilVisible(PRODUCTS_HEADER);
    }

    public WebElement getSortDropdown () {
        return this.waitUntilClickable(SORT_DROP);
    }
}
