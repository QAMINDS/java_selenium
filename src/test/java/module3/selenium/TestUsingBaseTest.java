package module3.selenium;
import common.BasePage;
import common.BaseTest;
import common.BaseTestMultiThread;
import google.pages.Google;
import org.testng.annotations.*;

public class TestUsingBaseTest extends BaseTestMultiThread {

    @Test(groups = {"sanity"})
    public void testYoutube() {

        BasePage page = new BasePage(this.getDriver(), 10, "https://www.youtube.com/");
        page.open();
        page.waitUntilLoaded();
        page.close();
    }

    @Test
    public void testGoogle() {

        Google page = new Google(this.getDriver(), 10, "https://www.google.com/");
        page.open();
        page.waitUntilLoaded();
        page.search("Selenium");
        page.close();

    }
}
