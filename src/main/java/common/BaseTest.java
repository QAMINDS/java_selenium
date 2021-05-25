package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;


public class BaseTest {
    private WebDriver driver;
    private String user;
    private String password;
    private WebDriverFactory.BrowserName browser;

    @BeforeClass
    //@Parameters({"user", "password",  "browser", })
    public void beforeClass() {
        //this.user = user;
        //this.password = password;
        this.browser = WebDriverFactory.BrowserName.CHROME;
        this.driver = WebDriverFactory.getDriver(this.browser);
    }

    @AfterClass
    public void afterClass() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public WebDriverFactory.BrowserName getBrowser() {
        return browser;
    }
}
