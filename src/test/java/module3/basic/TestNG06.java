package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Test Invocation Count
 */
public class TestNG06 {
    @Test(description = "My Test Case Description", invocationCount = 10)
    public void testPass() {
        Assert.assertTrue(5==5);
    }
}
