package google.pages;

import common.BasePage;
import google.components.ResultList;
import google.elements.SearchResultsElements;
import org.openqa.selenium.WebDriver;

public class SearchResults extends BasePage {
    public SearchResultsElements elements;
    public ResultList results;

    public SearchResults(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
        this.elements = new SearchResultsElements(driver, timeout);
        this.results = new ResultList(driver, timeout);
    }

    public void waitUntilLoaded() {
        this.elements.getSearchBox();
        this.elements.getResultsContainer();
    }

    public void search(String topic) {
        this.elements.getSearchBox().sendKeys(topic);
        this.elements.getSearchBtn().click();
    }
}
