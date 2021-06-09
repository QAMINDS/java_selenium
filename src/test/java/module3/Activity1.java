package module3;

import common.BaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity1 extends BaseTest {

    private final static String URL= "http://automationpractice.com/index.php?controller=contact\"";


    @Test (groups = "sanity")
    void testGoogle(){
        this.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.getDriver().get(URL);
    }
}
