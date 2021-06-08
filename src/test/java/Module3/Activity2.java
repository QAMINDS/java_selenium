package Module3;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Activity2 extends BasePage {

    public Activity2(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);
    }

    @Test
    public void testYoutube() {

        BasePage page = new BasePage(this.getDriver(),5, "https://www.youtube.com/");
        page.open();
        page.waitUntilLoaded();
        page.close();
    }
}
