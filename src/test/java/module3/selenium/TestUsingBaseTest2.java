package module3.selenium;

import common.BaseTest;
import common.BaseTestMultiThread;
import org.testng.annotations.Test;

public class TestUsingBaseTest2 extends BaseTestMultiThread {

    @Test
    public void testYoutube2() {
        this.getDriver().get("http://www.youtube.com");
    }

    @Test
    public void testGoogle2() {
        this.getDriver().get("http://www.google.com");
    }
}
