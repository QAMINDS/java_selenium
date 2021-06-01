package module3;

import common.BaseTestMultiThread;
import google.pages.Google;
import org.testng.annotations.Test;

public class TestNGexercise3 extends BaseTestMultiThread {

    @Test(groups = {"sanity"})
    public void testGoogle1() {
        Google page = new Google(this.getDriver(), 10, "http://www.google.com");
        page.open();
        page.waitUntilLoaded();
        page.search("Selenium");
        page.close();
    }

    @Test(groups = {"sanity"})
    public void testGoogle2() {
        Google page = new Google(this.getDriver(), 10, "http://www.google.com");
        page.open();
        page.waitUntilLoaded();
        page.search("Java");
        page.close();
    }

    @Test(groups = {"sanity"})
    public void testGoogle3() {
        Google page = new Google(this.getDriver(), 10, "http://www.google.com");
        page.open();
        page.waitUntilLoaded();
        page.search("Automation");
        page.close();
    }


}
