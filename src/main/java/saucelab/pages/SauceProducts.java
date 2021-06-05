package saucelab.pages;

import common.BasePage;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import saucelab.components.InventoryList;
import saucelab.elements.ProductsElements;

import java.util.ArrayList;
import java.util.List;

public class SauceProducts extends BasePage {
    public ProductsElements elements;
    public InventoryList inventoryList;
    private int i;

    public enum SortOption {
        AZ,
        ZA,
        LOHI,
        HILO,
    }

    public SauceProducts(WebDriver driver, int timeout) {
        super(driver, timeout);
        elements = new ProductsElements(driver, timeout);
        inventoryList = new InventoryList(driver, timeout);
    }

    @Override
    public void waitUntilLoaded() {
        this.elements.getProductsTitle();
        this.elements.getSortDropdown();
        this.elements.getBurgerButton();
    }

    public String title() {
        logger.info("Checking page title");
        String title = this.elements.getProductsTitle().getText();
        return title;
    }

    public void sort(SortOption option) {
        Select select = new Select(this.elements.getSortDropdown());
        select.selectByValue(option.name().toLowerCase());
        logger.info("Sorting by: " + option.name());
    }

    public void logout() {
        logger.info("Logging out");
        this.elements.getBurgerButton().click();
        this.elements.getLogoutLink().click();
    }

    public void selectAbout() {
        logger.info("Navigating to 'About'");
        this.elements.getBurgerButton().click();
        this.elements.getAboutLink().click();
    }

    public void goToTwitter() {
        logger.info("Navigating to Twitter");
        this.setCurrentTab();
        this.elements.getTwitterLink().click();
        this.switchToNewTab();
    }

    public int badgeNumber() {
        List<WebElement> badges = new ArrayList<>(this.elements.getCartBagde());

        if (badges.size() == 0) {
            i = 0;
            logger.info("Cart badge is not present");
        } else {
            String badgeText = badges.get(0).getText();
            i = Integer.parseInt(badgeText);
            logger.info("Cart badge number is: " + i);
        }
        return i;
    }

}
