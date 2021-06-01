package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.elements.LoginElements;

public class SauceLogin extends BasePage {
    public LoginElements elements;

    public SauceLogin(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
        this.elements = new LoginElements(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getUserName();
        this.elements.getPassword();
        this.elements.getLogin();
    }

    public SauceProducts login(String username, String password) {
        this.elements.getUserName().sendKeys(username);
        this.elements.getPassword().sendKeys(password);
        this.elements.getLogin().click();
        return new SauceProducts(this.getDriver(), this.getTimeout());
    }

    public boolean isValidUser() {
        return (this.elements.getErrorMsg() == null);
    }

}