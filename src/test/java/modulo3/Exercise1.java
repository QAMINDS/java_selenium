package modulo3;

import common.BaseTest;
import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.*;
import java.util.concurrent.TimeUnit;

public class Exercise1 extends BaseTest {
        private final  static  String URL = "https://www.google.com/";

        @Test
           void testGoogle() {

            this.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            this.getDriver().get(URL);


            String Url1 = this.getDriver().getCurrentUrl();
            Assert.assertEquals(Url1, URL);

        }
    }

