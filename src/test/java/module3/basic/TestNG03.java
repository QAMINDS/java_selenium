package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Test depends on method
 */
public class TestNG03 {
    @Test(description = "My Test Case Description")
    public void testPass() {
        Assert.assertTrue(5==5);
    }

    @Test(description = "Second Test Case Description", dependsOnMethods = {"testPass"})
    public void testFail() {
        Assert.assertTrue(5==4);
    }

    @Test(description = "Second Test Case Description", dependsOnMethods = {"testFail"})
    public void testExtra() {
        Assert.assertTrue(5==4);
    }
}
