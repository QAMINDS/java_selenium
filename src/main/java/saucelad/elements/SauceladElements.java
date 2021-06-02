package saucelad.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SauceladElements extends BaseElement {


    private final static By IMPUT_USER = By.id("user-name");
    private  final static By IMPUT_PASS = By.id("password");
    private  final static By BTN_LOGI= By.id("login-button");
    private final static By ERROR = By.xpath("//*[@data-test='erro']");


    public SauceladElements(WebDriver driver, int timeout) {
        super(driver, timeout);

    }
    public WebElement getUser() { return this.waitUntilClickable(IMPUT_USER); }
    public WebElement getPass() { return this.waitUntilClickable(IMPUT_PASS); }
    public WebElement getBtnLogin() { return this.waitUntilClickable(BTN_LOGI); }
    public WebElement getErrorMsg(){
        List<WebElement> elements = this.getDriver().findElements(ERROR);
        if(elements.size() > 0){
            return elements.get(0);
        }else {
            return null;
        }
    }
}
