package saucelad.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import saucelad.elements.CheckoutElement;
//import saucelad.elements.SauceladElements;

public class Checkout extends BasePage {

    private static String ADD_LABEL = "add to cart";

    private static String REMOVE_LABEL = "remove";

    public CheckoutElement elements;

    public Checkout(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
    }
    @Override
    public void waitUntilLoaded() {
        this.elements.getUser();
        this.elements.getPass();
        this.elements.getBtnLogin();
    }
    public void waitUntilProduct(){
        this.elements.getBtnAddToCar();
        this.elements.getCar();
        this.elements.getCheckout();
    }

    public void waitUntilCheckout(){
        this.elements.getFirsName();
        this.elements.getLastName();
        this.elements.getZip();
        this.elements.getBtnContinue();
    }
    public void login (String user, String pass) {
        this.elements.getUser().sendKeys(user);
        this.elements.getPass().sendKeys(pass);
        this.elements.getBtnLogin().click();
    }

    public void selectProduct(){
        this.elements.getBtnAddToCar().click();
        this.elements.getCar().click();
        this.elements.getCheckout().click();
    }
    public void checkout (String name, String lasname, String zip) {
        this.elements.getFirsName().sendKeys(name);
        this.elements.getLastName().sendKeys(lasname);
        this.elements.getZip().sendKeys(zip);
        this.elements.getBtnContinue().click();
        this.elements.getBtnFinish();
    }

    public void waitTitleCheckout(){
        this.elements.getTitleCheckout();
    }

    public Boolean isInCart() {
        return (this.elements.getBtnAddToCar().getText().toLowerCase().equals(REMOVE_LABEL));

    }

    public void addToCart() {
        if (!this.isInCart()) {
            this.elements.getBtnAddToCar().click();
        }
    }
    public void removeFromCart() {
        if (this.isInCart()) {
            this.elements.getBtnAddToCar().click();
        }
    }
    public boolean IsValidUser(){
        return(this.elements.getErrorMsg() == null);
    }

}
