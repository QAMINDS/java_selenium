package modulo3;

import common.BasePage;
import common.BaseTestMultiThread;
import google.pages.Google;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTestMultiThread {
    @Test(groups = {"sanity"})
    public void testYoutube(){
        BasePage page = new BasePage(this.getDriver(),10, "https://www.youtube.com/");
        page.open();
        page.waitUntilLoaded();
        page.close();

    }
    @Test(groups = {"sanity"})
    public void testGoogle(){
        Google page = new Google(this.getDriver(),10, "https://www.google.com/");
        page.open();
        page.waitUntilLoaded();
        page.search("selenium");
        page.close();
    }
}
