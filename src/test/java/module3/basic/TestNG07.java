package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Test Invocation Timeout
 */
public class TestNG07 {
    @Test(description = "My Test Case Description", invocationTimeOut = 2000)
    public void testPass() throws InterruptedException {
        Assert.assertTrue(5==5);
        Thread.sleep(5000);
    }
}
