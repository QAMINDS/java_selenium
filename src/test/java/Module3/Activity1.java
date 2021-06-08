package Module3;
import common.BaseTest;
import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Activity1 extends BaseTest {
        private final static String URL = "https://www.google.com/";
        @Test
        void testGoogle(){
            this.getDriver().get(URL);

            //String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(this.getDriver().getCurrentUrl(), URL, "Wrong URL");

            }
    }

