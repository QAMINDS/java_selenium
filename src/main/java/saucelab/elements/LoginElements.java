package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements extends BaseElement {
    private final static By USER_NAME = By.id("user-name");

    private final static By PASSWORD = By.id("password");

    private final static By LOGIN_BTN = By.id("login-button");

    private  final static  By MSG_ERROR = By.xpath("//*[@data-test='error']");

    public LoginElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getUserName() {
        return this.waitUntilClickable(USER_NAME);
    }

    public WebElement getPassword() {
        return this.waitUntilClickable(PASSWORD);
    }

    public WebElement getLoginButton() {
        return this.waitUntilClickable(LOGIN_BTN);
    }

    public WebElement getErrorMsg(){ return  this.waitUntilVisible(MSG_ERROR);}
}
