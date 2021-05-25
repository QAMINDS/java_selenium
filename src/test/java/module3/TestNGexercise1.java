package module3;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGexercise1 {

    @Test
    public void testGoogleNavigate() {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        final String googleURL = "https://www.google.com.mx/";
        driver.get(googleURL);

        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(currentURL, googleURL, "Wrong URL");

        driver.close();

    }
}
