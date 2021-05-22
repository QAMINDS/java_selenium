package google.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultsElements extends BaseElement {
    public final static By SEARCH_BOX = By.name("q");

    public final static By SEARCH_RESULTS_CONTAINER = By.id("search");

    public GoogleResultsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getSearchBox() {
        return this.waitUntilClickable(SEARCH_BOX);
    }

    public WebElement getResultsContainer() {
        return this.waitUntilClickable(SEARCH_RESULTS_CONTAINER);
    }
}
