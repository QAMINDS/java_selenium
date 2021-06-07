package saucelad.elements;

import common.BaseElement;
import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SauceladElements extends BaseElement {

    WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

    private final static By IMPUT_USER = By.id("user-name");
    private  final static By IMPUT_PASS = By.id("password");
    private  final static By BTN_LOGI= By.id("login-button");
    private final static By ERROR = By.xpath("//*[@data-test='erro']");



    //WebElement error = driver.findElement(By.xpath("//*[@data-test='erro']"));

    public SauceladElements(WebDriver driver, int timeout) {
        super(driver, timeout);

    }
    public WebElement getUser() { return this.waitUntilClickable(IMPUT_USER); }
    public WebElement getPass() { return this.waitUntilClickable(IMPUT_PASS); }
    public WebElement getBtnLogin() { return this.waitUntilClickable(BTN_LOGI); }
    //public WebElement geterrorTex(){return this.waitUntilClickable(error);}
    public WebElement getErrorMsg(){
        List<WebElement> elements = this.getDriver().findElements(ERROR);
        if(elements.size() > 0){
            return elements.get(0);
        }else {
            return null;
        }
    }
}
