package saucelab.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsElements extends BaseElement{

    private final static By PRODUCTS_TITLE = By.xpath("//*[@class='title' and contains(text(),'Products')]");

    private final static By SORT_DROP = By.xpath("//*[@data-test='product_sort_container']");

    private final static By BURGER_BTN = By.id("react-burger-menu-btn");

    private final static By ABOUT_LINK = By.id("about_sidebar_link");

    private final static By LOGOUT_LINK = By.id("logout_sidebar_link");

    private final static By TWITTER_LINK = By.xpath("//a[@href='https://twitter.com/saucelabs']");

    private final static By CART_BAGDE = By.xpath("//span[@class='shopping_cart_badge']");


    public ProductsElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public WebElement getProductsTitle() {
        return this.waitUntilVisible(PRODUCTS_TITLE);
    }

    public WebElement getSortDropdown () {
        return this.waitUntilClickable(SORT_DROP);
    }

    public WebElement getBurgerButton (){
        return this.waitUntilClickable(BURGER_BTN);
    }

    public WebElement getAboutLink (){
        return this.waitUntilClickable(ABOUT_LINK);
    }

    public WebElement getLogoutLink (){
        return this.waitUntilClickable(LOGOUT_LINK);
    }

    public WebElement getTwitterLink (){
        return this.waitUntilClickable(TWITTER_LINK);
    }

    public List<WebElement> getCartBagde() {
        return this.dontWaitForElements(CART_BAGDE);
    }

}

