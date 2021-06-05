package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static common.QAMindsExpectedConditions.subElementClickable;
import static common.QAMindsExpectedConditions.subElementVisibility;

public class BaseElement {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final int timeout;
    private final WebElement rootElement;
    protected final Logger logger = Logger.getLogger(BaseElement.class);

    public BaseElement(WebDriver driver, int timeout) {
        this(driver, timeout, null);
    }

    public BaseElement(WebDriver driver, int timeout, WebElement rootElement) {
        this.driver = driver;
        this.timeout = timeout;
        this.wait = new WebDriverWait(this.driver, timeout);
        this.rootElement = rootElement;
    }

    public WebElement waitUntilClickable(By locator) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilVisible(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForElements(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement getRootElement() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.rootElement));
    }

    public WebElement waitUntilSubElementClickable (final By locator) {
        return this.wait.until(subElementClickable(this.rootElement, locator));
    }

    public WebElement waitUntilSubElementVisible (final By locator) {
        return this.wait.until(subElementVisibility(this.rootElement, locator));
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
