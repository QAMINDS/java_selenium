package module3.selenium;

import common.BaseTestMultiThread;
import google.pages.Google;
import google.pages.SearchResults;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestGoogle extends BaseTestMultiThread {
    private final static String URL = "https://www.google.com";
    private final static int TIMEOUT = 10;

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object [][] {
                {"Selenium"},
                //{"Java"},
                //{"TestNG"},
                //{"QA Minds"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testSearchGoogle(String topic) {
        Google google = new Google(this.getDriver(), TIMEOUT, URL);
        google.open();
        google.waitUntilLoaded();
    }
}
