package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItemElements extends BaseElement {


    private final static By TITLE= By.xpath(".//*[@class='inventory_item_name']");

    private final static By DESCRIPTION= By.xpath(".//*[@class='inventory_item_desc']");

    private final static By PRICE= By.xpath(".//*[@class='inventory_item_price']");

    private final static By BUTTON = By.xpath(".//*[contains(@class, 'btn_inventory')]");

    private final static By DETAILS_TITLE= By.xpath(".//*[@class='inventory_details_name large_size']");

    private final static By IMAGE= By.xpath(".//*[@class='inventory_item_img']");


    public InventoryItemElements(WebDriver driver, int timeout, WebElement rootElement) {
        super(driver, timeout, rootElement);
    }

    public WebElement getTitle() {
        return this.waitUntilSubElementVisible(TITLE);
    }

    public WebElement getDetailsTitle() {
        return this.waitUntilSubElementVisible(DETAILS_TITLE);
    }

    public WebElement getDescription() {
        return this.waitUntilSubElementVisible(DESCRIPTION);
    }

    public WebElement getPrice() {
        return this.waitUntilSubElementVisible(PRICE);
    }

    public WebElement getButton() {
        return this.waitUntilSubElementClickable(BUTTON);
    }

    public WebElement getImage() {
        return this.waitUntilSubElementClickable(IMAGE);
    }



    }
