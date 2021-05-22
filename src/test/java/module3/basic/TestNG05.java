package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Test Disabled
 */
public class TestNG05 {
    @Test(description = "My Test Case Description", enabled = false)
    public void testPass() {
        Assert.assertTrue(5==5);
    }
}
