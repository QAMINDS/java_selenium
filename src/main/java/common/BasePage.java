package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;
    private String url;
    private int timeout;
    protected final Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver, int timeout) {
        this(driver, timeout, null);
    }

    public BasePage(WebDriver driver, int timeout, String url) {
        this.driver = driver;
        this.url = url;
        this.timeout =timeout;
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
        logger.info("Close: " + this.url);
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
}