package google.pages;

import common.BasePage;
import google.elements.GoogleElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Google extends BasePage {
    public GoogleElements elements;

    public Google(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
        this.elements = new GoogleElements(driver, timeout);
    }

    public void waitUntilLoaded() {
        this.elements.getSearchBox();
        this.elements.getSearchButton();
        this.elements.getFeelingLuckyButton();
    }

    public void search(String topic) {
        this.elements.getSearchBox().sendKeys(topic);
        this.elements.getSearchBox().sendKeys(Keys.TAB);
        this.elements.getSearchButton().click();
    }

    public void searchFeelingLucky(String topic) {
        this.elements.getFeelingLuckyButton().sendKeys(topic);
        this.elements.getFeelingLuckyButton().sendKeys(Keys.TAB);
        this.elements.getFeelingLuckyButton().click();
    }
}
