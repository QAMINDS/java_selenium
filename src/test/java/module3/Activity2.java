package module3;

import common.BasePage;
import common.BaseTestMultiThread;
import google.Pages.Google;
import org.testng.annotations.Test;

public class Activity2 extends BaseTestMultiThread {

    @Test(groups = {"sanity"})
    public void testGoogle(){
        Google page = new Google(this.getDriver(),10,"https://www.google.com.mx/");
        page.open();
        page.waitUntilLoaded();
        page.search("Selenium");
        page.close();
    }

    @Test
    public void testYoutube(){
        BasePage page = new BasePage(this.getDriver(),10,"https://www.youtube.com/");
        page.open();
        page.waitUntilLoaded();
        page.close();
    }
   @Test
    public void testAmazon(){
        BasePage page = new BasePage(this.getDriver(),10,"https://www.amazon.com/");
        page.open();
        page.waitUntilLoaded();
        page.close();
    }
}
