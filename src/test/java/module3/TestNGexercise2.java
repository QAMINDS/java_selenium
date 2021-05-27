package module3;

import common.BasePage;
import common.BaseTestMultiThread;
import org.testng.annotations.Test;

public class TestNGexercise2 extends BaseTestMultiThread {

    @Test(groups = {"sanity"})
    public void testYoutube() {
        BasePage page = new BasePage(this.getDriver(), 10, "http://www.youtube.com");
        page.open();
        page.waitUntilLoaded();
        page.close();
    }

    @Test(groups = {"sanity"})
    public void testGoogle() {
        BasePage page = new BasePage(this.getDriver(), 10, "http://www.google.com");
        page.open();
        page.waitUntilLoaded();
        page.close();
    }

    @Test(groups = {"sanity"})
    public void testAmazonMX() {
        BasePage page = new BasePage(this.getDriver(), 10, "https://www.amazon.com.mx/");
        page.open();
        page.waitUntilLoaded();
        page.close();
    }
}
