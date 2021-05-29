package google.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsElements extends BaseElement {
    private final static By SEARCH_BOX = By.name("q");

    private final static By SEARCH_RESULTS_CONTAINER = By.id("search");

    private final static By SEARCH_BTN = By.xpath("//button[@type='submit']");

    public SearchResultsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getSearchBox() {
        return this.waitUntilClickable(SEARCH_BOX);
    }

    public WebElement getResultsContainer() {
        return this.waitUntilClickable(SEARCH_RESULTS_CONTAINER);
    }

    public WebElement getSearchBtn() {return this.waitUntilClickable(SEARCH_BTN);}
}
