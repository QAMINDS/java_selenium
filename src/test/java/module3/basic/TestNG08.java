package module3.basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
Test Data Provider
 */
public class TestNG08 {

    @DataProvider(name = "testDataProvider")
    public Object[][]  testDataProvider() {
        return new Object [][] {
                {"First Value"}, {"Second Value"}
        };
    }

    @Test(description = "My Test Case Description", dataProvider = "testDataProvider")
    public void testPass(String myArg) throws InterruptedException {
        System.out.println(myArg);
    }
}
