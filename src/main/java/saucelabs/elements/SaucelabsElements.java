package saucelabs.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaucelabsElements extends BaseElement {
    private final static By USER_NAME_TEXT = By.id("user-name");

    private final static By PASSWORD_TEXT = By.id("password");

    private final static By LOGIN_BTN = By.id("login-button");

    private final static By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public SaucelabsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getUserNameEditText() {
        return this.waitUntilClickable(USER_NAME_TEXT);
    }

    public WebElement getPasswordEditText() {
        return this.waitUntilClickable(PASSWORD_TEXT);
    }

    public WebElement getLoginButton() {
        return this.waitUntilClickable(LOGIN_BTN);
    }

    public WebElement getErrorMessage() {
        List<WebElement> elements = this.getDriver().findElements(ERROR_MESSAGE);
        if (elements.size() > 0) {
            return elements.get(0);
        } else {
            return null;
        }
    }
}
