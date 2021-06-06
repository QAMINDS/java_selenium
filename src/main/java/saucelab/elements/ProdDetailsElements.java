package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdDetailsElements extends BaseElement {

    private final static By BACK_BUTTON = By.id("back-to-products");

    private final static By PROD_NAME = By.xpath("//div[@class='inventory_details_name large_size']");

    private final static By PROD_BUTTON = By.xpath("//button[contains(@class, 'btn_inventory')]");

    public ProdDetailsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getBackButton() {
        return this.waitUntilClickable(BACK_BUTTON);
    }

    public WebElement getProdName() {
        return this.waitUntilVisible(PROD_NAME);
    }

    public WebElement getProdButton() {
        return this.waitUntilClickable(PROD_BUTTON);
    }

}
