package module1.lessons.lesson052921;

import common.BasePage;
import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tester extends BaseTestMultiThread {

    private final String YOUTUBE_URL = "https://www.youtube.com";

    @Test(groups = {"sanity"})
    public void  testPage() {
        BasePage basePage = new BasePage(this.getDriver(), 10, YOUTUBE_URL);
        basePage.open();
        basePage.waitUntilLoaded();
        basePage.close();
    }
}
