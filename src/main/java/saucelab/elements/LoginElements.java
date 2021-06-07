package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginElements extends BaseElement {

    private final static By USER = By.name("user-name");

    private final static By PWD = By.name("password");

    private final static By LOGIN_BTN = By.name("login-button");

    private final static By ERROR = By.xpath("//*[@data-test='error']");

    public LoginElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getUserName(){
        return this.waitUntilClickable(USER);
    }

    public WebElement getPassword(){
        return this.waitUntilClickable(PWD);
    }

    public WebElement getLogin(){
        return this.waitUntilClickable(LOGIN_BTN);

    }


    public WebElement getErrorMsg() {
        List<WebElement> elements = this.getDriver().findElements(ERROR);
        if (!elements.isEmpty()) {
            return elements.get(0);
        } else {
            return null;
        }
    }


}
