package saucelab.pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucelab.elements.LoginElements;

public class Login extends BasePage {
    public LoginElements elements;

    public Login(WebDriver driver, int timeout, String url){
        super(driver,timeout,url);
        this.elements = new LoginElements(driver, timeout);
    }


    public void waitUntilLoaded() {
        this.elements.getUserName();
        this.elements.getPassword();
        this.elements.getLogin();
    }

    public Producto login(String user,String password){
        elements.getUserName().sendKeys(user);
        elements.getPassword().sendKeys(password);
        elements.getLogin().click();
        return new Producto(this.getDriver(),this.getTimeout());
    }


    public boolean isValidUser(){
        return (this.elements.getErrorMsg()==null);
    }

}
