package saucelabs.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelabs.elements.LoginElements;
//import org.openqa.selenium.WebElement;
//import saucelab.elements.LoginElements;

public class Login extends BasePage {
    public LoginElements elements;

    public Login(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
        elements = new LoginElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getUserName();
        this.elements.getPassword();
        this.elements.getLogin();
    }

    public Product login(String user, String password) {
        this.elements.getUserName().sendKeys(user);
        this.elements.getPassword().sendKeys(password);
        this.elements.getLogin().click();
        return new Product(this.getDriver(), this.getTimeout());
    }

    public boolean isValidUser() {
        return (this.elements.getErrorMsg() == null);
    }
}
