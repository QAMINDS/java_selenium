package saucelad.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutElement extends BaseElement {

    private final static By IMPUT_USER = By.id("user-name");
    private  final static By IMPUT_PASS = By.id("password");
    private  final static By BTN_LOGI= By.id("login-button");
    private final static By ERROR = By.xpath("//*[@data-test='erro']");

    private final static  By BTN_ADD_TO_CART = By.id("add-to-cart-sauce-labs-backpack");
    private final static By CAR = By.className("shopping_cart_link");
    private final static By CHECKOUT = By.id("checkout");
    private final static By FIRS_NAME = By.id("first-name");
    private final static By LAST_NAME = By.id("last-name");
    private final static By ZIP = By.id("postal-code");
    private final static By BTN_CONTINUE = By.id("continue");

    private final static By BTN_FINISH = By.id("finish");
    private final static By TITLE_CHECKOUT = By.id("//*[@class='complete-header']");

    public CheckoutElement(WebDriver driver, int timeout) {
        super(driver, timeout);
    }
    public WebElement getUser() { return this.waitUntilClickable(IMPUT_USER); }
    public WebElement getPass() { return this.waitUntilClickable(IMPUT_PASS); }
    public WebElement getBtnLogin() { return this.waitUntilClickable(BTN_LOGI); }

    public WebElement getBtnAddToCar() { return this.waitUntilSubElementClickable(BTN_ADD_TO_CART); }
    public WebElement getCar() { return this.waitUntilClickable(CAR); }
    public WebElement getCheckout() { return this.waitUntilClickable(CHECKOUT); }

    public WebElement getFirsName() { return this.waitUntilClickable(FIRS_NAME); }
    public WebElement getLastName() { return this.waitUntilClickable(LAST_NAME); }
    public WebElement getZip() { return this.waitUntilClickable(ZIP); }
    public WebElement getBtnContinue() { return this.waitUntilClickable(BTN_CONTINUE); }

    public WebElement getBtnFinish() { return this.waitUntilClickable(BTN_FINISH); }
    public WebElement getTitleCheckout() { return this.waitUntilVisible(TITLE_CHECKOUT); }

    public WebElement getErrorMsg(){
        List<WebElement> elements = this.getDriver().findElements(ERROR);
        if(elements.size() > 0){
            return elements.get(0);
        }else {
            return null;
        }
    }
}