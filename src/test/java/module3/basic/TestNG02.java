package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Test;


/*
Test Description and groups
 */
public class TestNG02 {
    @Test(description = "My Test Case Description", groups = {"sanity", "regression", "login"})
    public void testPass() {
        Assert.assertTrue(5==5);
    }

    @Test(description = "Second Test Case Description", groups = {"regression", "products"})
    public void testFail() {
        Assert.assertTrue(5==4);
    }
}
