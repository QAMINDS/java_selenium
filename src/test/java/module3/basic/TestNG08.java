package module3.basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
Test Data Provider
 */
public class TestNG08 {

    @DataProvider(name = "my custom name")
    public Object[][]  testDataProvider() {
        return new Object [][] {
                {"User 1", "Password 1", 10},
                {"User 2", "Password 2", 10},
                {"User 3", "Password 3", 10}
        };
    }

    @Test(description = "My Test Case Description", dataProvider = "my custom name")
    public void testPass(String user, String password, int total) {
        System.out.println(user);
        System.out.println(password);
        System.out.println(total);
    }
}
