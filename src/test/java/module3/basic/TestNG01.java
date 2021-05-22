package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/*
Test Annotation
 */
public class TestNG01 {
    @Test
    public void testValidLogin() {
        Assert.assertTrue(5==5);
    }

    @Test()
    public void testInvalidLogin() {
        Assert.assertTrue(5==4);
    }
}
