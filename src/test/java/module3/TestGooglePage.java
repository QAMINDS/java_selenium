package module3;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestGooglePage {
    
    private final static String URL = "https://www.google.com.mx/";

    @Test
    public void testGoogle(){
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get(URL);

        Assert.assertEquals(URL,driver.getCurrentUrl(),"Nombre de la página diferente");
        driver.close();

    }

}
