package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseElement {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final int timeout;
    protected final Logger logger = Logger.getLogger(BaseElement.class);

    public BaseElement(WebDriver driver, int timeout) {
        this.driver = driver;
        this.timeout = timeout;
        this.wait = new WebDriverWait(this.driver, timeout);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement waitUntilClickable(By locator) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilVisible(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public int getTimeout() {
        return timeout;
    }
}
