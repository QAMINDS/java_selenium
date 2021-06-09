package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginElements extends BaseElement {

    private  final static By USERNAME  = By.id("user-name");
    private  final static By PASSWORD  = By.id("password");
    private final static  By LOGINBTN = By.id("login-button");
    //private final static By ERROR = By.xpath("//*[@data-provider ='error']");
    private final static By ERROR = By.xpath("//*[@data-test='error']");

    public LoginElements(WebDriver driver, int timeout){
        super(driver,timeout);
    }

    public WebElement getUserName(){
        return  this.waitUntilClickable(USERNAME);
    }

    public WebElement getPassword(){
        return  this.waitUntilClickable(PASSWORD);
    }

    public WebElement getLogin(){
        return this.waitUntilClickable(LOGINBTN);
    }

    public WebElement getErrorMsg(){
        List<WebElement> elements = this.getDriver().findElements(ERROR);
        if(!elements.isEmpty()){
            return elements.get(0);
        }else {
            return null;
        }
    }

}
