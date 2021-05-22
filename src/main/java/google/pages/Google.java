package google.pages;

import common.BasePage;
import google.elements.GoogleElements;
import org.openqa.selenium.WebDriver;

public class Google extends BasePage {
    private GoogleElements elements;
    public Google(WebDriver driver, String url, int timeout) {
        super(driver, url, timeout);
        this.elements = new GoogleElements(driver, timeout);
    }

    public void waitUntilLoaded() {
        this.elements.getSearchBox();
        this.elements.getSearchButton();
        this.elements.getFeelingLuckyButton();
    }

    public GoogleResults search(String topic) {
        this.elements.getSearchBox().sendKeys(topic);
        this.elements.getSearchButton().click();
        return new GoogleResults(this.getDriver(), this.getUrl() + "/webhp", this.getTimeout());
    }
}
