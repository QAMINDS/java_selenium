package google.pages;

import common.BasePage;
import google.elements.GoogleElements;
import google.elements.GoogleResultsElements;
import org.openqa.selenium.WebDriver;

public class GoogleResults extends BasePage {
    private GoogleResultsElements elements;
    public GoogleResults(WebDriver driver, String url, int timeout) {
        super(driver, url, timeout);
        this.elements = new GoogleResultsElements(driver, timeout);
    }

    public void waitUntilLoaded() {
        this.elements.getSearchBox();
        this.elements.getResultsContainer();
    }
}
