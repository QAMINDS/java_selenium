package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.elements.SaucelabsElements;

public class Saucelabs extends BasePage {
    public SaucelabsElements elements;

    public Saucelabs(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new SaucelabsElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getSignInButton();
    }
}
