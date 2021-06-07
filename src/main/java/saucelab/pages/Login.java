package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import saucelab.elements.LoginElements;

public class Login extends BasePage {
    public LoginElements elements;

    public Login(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
        this.elements = new LoginElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getUserName();
        this.elements.getPassword();
        this.elements.getLoginButton();
    }

    public void login(String user, String password) {
        this.elements.getUserName().sendKeys(user);
        this.elements.getPassword().sendKeys(password);
        this.elements.getLoginButton().click();

    }


}
