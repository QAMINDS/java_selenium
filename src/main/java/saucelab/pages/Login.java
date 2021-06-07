package saucelab.pages;

import common.BasePage;
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
        this.elements.getLogin();
    }

    public Product login(String user, String password) {
        this.elements.getUserName().sendKeys(user);
        this.elements.getPassword().sendKeys(password);
        this.elements.getLogin().click();
        return new Product(this.getDriver(), this.getTimeout());

    }

//    public boolean isValidUser(){
//        try{
//            this.elements.getErrorMsg();
//            return false;
//        }catch(Exception exception){
//            return true;
//        }
//    }

public boolean isValidUser() {
    return (this.elements.getErrorMsg() == null);
    }



}
