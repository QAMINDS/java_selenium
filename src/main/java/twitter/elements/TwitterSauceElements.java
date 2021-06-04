package twitter.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TwitterSauceElements extends BaseElement {

    private final static By SEARCH_BOX = By.xpath("//input[contains(@placeholder,'Twitter')]");


    public TwitterSauceElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getSearchBox() {
        return this.waitUntilClickable(SEARCH_BOX);
    }

}
