package module3.selenium;



import common.BaseTest;
import common.BaseTestMultiThread;
import org.testng.annotations.Test;

public class TestThreadSafe extends BaseTestMultiThread {
    @Test
    public void testGoogle() {
        this.getDriver().get("http://www.google.com");
    }

    @Test
    public void testAmazon() {
        this.getDriver().get("http://www.amazon.com");
    }

    @Test
    public void testYoutube() {
        this.getDriver().get("http://www.youtube.com");
    }
}
