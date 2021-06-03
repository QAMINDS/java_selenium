package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;

public class BaseTest {
    private WebDriver driver;
    private String username;
    private String password;
    private WebDriverFactory.BrowserName browser;

    @BeforeClass (alwaysRun=true)
    //@Parameters({"username", "password",  "browser", })
    public void beforeClass() {
        //this.username = username;
        //this.password = password;
        this.browser = WebDriverFactory.BrowserName.CHROME;
        this.driver = WebDriverFactory.getDriver(this.browser);
    }

    @AfterClass (alwaysRun=true)
    public void afterClass() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUser() {
        return username;
    }

    public WebDriverFactory.BrowserName getBrowser() {
        return browser;
    }
}