package google.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleElements extends BaseElement {

    private final static By SEARCH_BOX = By.name("q");

    private final static By SEARCH_BTN = By.xpath("//*[@name='btnK' and not(ancestor::div[@jsname])]");

    private final static By LUCKY_BTN = By.xpath("//*[@name='btnI' and not(ancestor::div[@jsname])]");

    public GoogleElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getSearchBox() {
        return this.waitUntilClickable(SEARCH_BOX);
    }

    public WebElement getSearchButton() {
        return this.waitUntilClickable(SEARCH_BTN);
    }

    public WebElement getFeelingLuckyButton() {
        return this.waitUntilClickable(LUCKY_BTN);
    }
}
