package twitter.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import twitter.elements.TwitterSauceElements;

public class TwitterSaucelabs extends BasePage {
    public TwitterSauceElements elements;

    public TwitterSaucelabs(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new TwitterSauceElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getSearchBox();
    }
}
