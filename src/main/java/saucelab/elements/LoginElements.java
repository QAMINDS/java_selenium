package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginElements extends BaseElement {

    private final static By USERNAME_BOX = By.id("user-name");

    private final static By PSW_BOX = By.id("password");

    private final static By LOGIN_BTN = By.id("login-button");

    private final static By ERROR_MSG = By.xpath("//*[contains(text(),'Epic sadface: Username and password do not match a')]");

    public LoginElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getUserName() {
        return this.waitUntilClickable(USERNAME_BOX);
    }

    public WebElement getPassword() {
        return this.waitUntilClickable(PSW_BOX);
    }

    public WebElement getLogin() {
        return this.waitUntilClickable(LOGIN_BTN);
    }

    public WebElement getErrorMsg() {
        List<WebElement> elements = this.getDriver().findElements(ERROR_MSG);
        if (!elements.isEmpty()) {
            return elements.get(0);
        } else {
            return null;
        }
    }
}

