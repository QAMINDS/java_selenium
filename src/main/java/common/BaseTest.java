package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected String user;
    protected String password;
    protected WebDriverFactory.BrowserName browser;

    @BeforeClass
    @Parameters({"user", "password",  "browser", })
    public void beforeClass(String user, String password, String browser) {
        this.user = user;
        this.password = password;
        this.browser = WebDriverFactory.BrowserName.valueOf(browser.toUpperCase());
    }

    @BeforeMethod
    public void beforeMethod() {
        this.driver = WebDriverFactory.getDriver(this.browser);
    }

    @AfterMethod
    public void afterMethod() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
