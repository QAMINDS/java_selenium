package module3;

import common.BaseTest;
import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class exercise1 extends BaseTest {

    private final String googleURL= "https://www.google.com/";

    @Test
    void testGoogle(){
  //      WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
 //      driver.get(googleURL);
        this.getDriver().get(googleURL);
        String currentURL = getDriver().getCurrentUrl();
  //      Assert.assertEquals(driver.getCurrentUrl(),googleURL,"Invalid URL");
        Assert.assertEquals(currentURL,googleURL, "Invalid URL");

  //     driver.close();

    }


}
