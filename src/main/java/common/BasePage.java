package common;

import jdk.swing.interop.SwingInterOpUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BasePage {
    private WebDriver driver;
    private String url;
    private int timeout;
    protected String currentTab;
    protected final Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver, int timeout) {
        this(driver, timeout, null);
    }

    public BasePage(WebDriver driver, int timeout, String url) {
        this.driver = driver;
        this.url = url;
        this.timeout = timeout;
    }

    public void open() {
        if (this.url != null) {
            logger.info("Open: " + this.url);
            this.driver.get(url);
        } else {
            logger.warn("Cannot open empty url");
        }
    }

    public void close() {
        logger.info("Close: " + this.url + "\n");
        this.driver.close();
    }

    public void waitUntilLoaded() {
        logger.info("Wait until loaded...");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getCurrentUrl() {
        String currentURL = this.driver.getCurrentUrl();
        return currentURL;
    }

    public void setCurrentTab() {
        String tempTab = this.driver.getWindowHandle();
        this.currentTab = tempTab;
        //System.out.println("Current tab: " + currentTab);
    }

    public void switchToNewTab() {
        ArrayList<String> newTab = new ArrayList<>(this.driver.getWindowHandles());
        newTab.remove(currentTab);
        this.driver.switchTo().window(newTab.get(0));
        //System.out.println("New tab: " + newTab.get(0));
    }

}
