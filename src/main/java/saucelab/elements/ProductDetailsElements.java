package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsElements extends BaseElement {

    private final static By TITLE= By.xpath("//*[@class='inventory_details_name large_size']");

    private final static By DESCRIPTION= By.xpath("//*[@class='inventory_details_desc large_size']");

    private final static By PRICE= By.xpath("//*[@class='inventory_details_price']");

    private final static By BUTTON = By.xpath("//*[contains(@class, 'btn_inventory')]");
    private final static By BTN_BACK = By.xpath("//*[@data-test='back-to-products']");

    public ProductDetailsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getTitle() {
        return this.waitUntilVisible(TITLE);
    }

    public WebElement getDescription() {

        return this.waitUntilVisible(DESCRIPTION);
    }

    public WebElement getPrice() {
        return this.waitUntilVisible(PRICE);
    }

    public WebElement getButton() {
        return this.waitUntilVisible(BUTTON);
    }


    public WebElement getBtnBackToProduct(){
        return this.waitUntilClickable(BTN_BACK);
    }

}
