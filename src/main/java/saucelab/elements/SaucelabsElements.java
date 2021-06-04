package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SaucelabsElements extends BaseElement {

    private final static By SIGNIN_BTN = By.xpath("//span[contains(text(),'Sign in')]");


    public SaucelabsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getSignInButton() {
        return this.waitUntilClickable(SIGNIN_BTN);
    }

}
