package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class BasePage {
    private WebDriver driver;
    private String url;
    private int timeout;
    protected final Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver, String url, int timeout) {
        this.driver = driver;
        this.url = url;
        this.timeout =timeout;
    }

    public void open() {
        logger.info("Open: " + this.url);
        this.driver.get(url);
    }

    public void close() {
        logger.info("Close: " + this.url);
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
