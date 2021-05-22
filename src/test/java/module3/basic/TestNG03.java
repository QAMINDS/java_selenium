package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Test depends on method
 */
public class TestNG03 {
    @Test(description = "My Test Case Description")
    public void testLogin() {
        Assert.assertTrue(5==5);
    }

    @Test(description = "Second Test Case Description", dependsOnMethods = {"testLogin"})
    public void testProducts() {
        Assert.assertTrue(5==4);
    }

    @Test(description = "Second Test Case Description", dependsOnMethods = {"testProducts"})
    public void testCart() {
        Assert.assertTrue(5==4);
    }
}
