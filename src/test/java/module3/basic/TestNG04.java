package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Test Priority
 */
public class TestNG04 {
    @Test(description = "My Test Case Description", priority = 1)
    public void testPass() {
        Assert.assertTrue(5==5);
    }

    @Test(description = "Second Test Case Description", priority = 1)
    public void testFail() {
        Assert.assertTrue(5==4);
    }

    @Test(description = "Second Test Case Description",  priority = 0)
    public void testExtra() {
        Assert.assertTrue(5==4);
    }
}
