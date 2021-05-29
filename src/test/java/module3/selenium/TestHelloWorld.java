package module3.selenium;


import common.BaseTest;
import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestHelloWorld extends BaseTest {
    private final static String URL = "https://www.google.com/";

    /*
    @Test
    void testGoogle() {
        this.driver.get(URL);
        Assert.assertEquals(driver.getCurrentUrl(), URL, "Invalid url");
    }

    @Test(dependsOnMethods = "testGoogle")
    void testGoogle2() {
        this.driver.get(URL);
        Assert.assertEquals(driver.getCurrentUrl(), URL, "Invalid url");
    }
    */
}
