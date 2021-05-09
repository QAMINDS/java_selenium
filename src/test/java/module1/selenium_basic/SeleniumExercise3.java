package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SeleniumExercise3 {

    //private static WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.PERFCHROME);
    private static WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.PERFFOX);
    private static String currentURL;

    public static void main(String[] args) {

        final String googleEURL = "https://www.google.com";
        final String facebookURL = "https://www.facebook.com/";
        final String espnURL = "https://www.espn.com/";

        driver.get(googleEURL);
        printcurrentURL();

        driver.get(facebookURL);
        printcurrentURL();

        driver.get(espnURL);
        printcurrentURL();

        driver.navigate().back();
        driver.navigate().back();
        printcurrentURL();

        driver.navigate().forward();
        printcurrentURL();

        System.out.println("Assert that the current URL is Facebook page");

        try {
            Assert.assertEquals(currentURL, facebookURL);
        } catch (Throwable e) {
            System.out.println("current URL is not Facebook page! " + e);

        }

        //System.out.println("still running after assert!");

        driver.navigate().refresh();
        printcurrentURL();

        driver.close();

    }

    static void printcurrentURL() {
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL: " + currentURL);
    }
}
