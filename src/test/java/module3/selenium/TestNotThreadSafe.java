package module3.selenium;

import common.BaseTest;
import org.testng.annotations.Test;

public class TestNotThreadSafe extends BaseTest {
    @Test
    public void testGoogle() {
        this.driver.get("http://www.google.com");
    }
}
