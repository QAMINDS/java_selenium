package module3;

import org.testng.Assert;
import org.testng.annotations.Test;
import common.BaseTest;

public class TestNGexercise1 extends BaseTest {

    @Test (groups = {"sanity"})
    public void testGoogleNavigate() {

        final String googleURL = "https://www.google.com.mx/";
        this.getDriver().get(googleURL);

        String currentURL = this.getDriver().getCurrentUrl();

        Assert.assertEquals(currentURL, googleURL, "Wrong URL");

    }
}
