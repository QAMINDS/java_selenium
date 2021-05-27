package module1.lessons.lesson052621;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing extends BaseTestMultiThread {

    final String AMAZON_URL = "https://www.amazon.com.mx/";
//    WebDriver driver;
//
//    @BeforeSuite
//    private void setup() {
//        driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
//    }

//    @Test
    @Test(groups = {"sanity"})
    public void  testPage() {
        this.getDriver().get(AMAZON_URL);
        String currentUrl = this.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, AMAZON_URL, "Invalid url");
        Assert.assertTrue(true);

        this.getDriver().close();
    }
}
