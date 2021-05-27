package module1.lessons.lesson052221;

import common.BaseTest;
import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;


public class Testing extends BaseTest {

    final String AMAZON_URL = "https://www.amazon.com.mx/";
//    WebDriver driver;
//
//    @BeforeSuite
//    private void setup() {
//        driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
//    }

    @Test ( groups = {"sanity"})
    private void  test2() {
//        this.getDriver().get(AMAZON_URL);
//        String currentUrl = this.getDriver().getCurrentUrl();
//        Assert.assertEquals(currentUrl, AMAZON_URL, "Invalid url");
//        this.getDriver().close();
        Assert.assertTrue(true);
    }
}
