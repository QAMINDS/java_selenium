package module3.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Test Annotation
 */
public class TestNG01 {
    @Test
    public void testPass() {
        Assert.assertTrue(5==5);
    }

    @Test
    public void testFail() {
        Assert.assertTrue(5==4);
    }
}
