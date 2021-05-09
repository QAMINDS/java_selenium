package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class SeleniumExercise1 {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        String googleURL = "https://www.google.com";

        driver.get(googleURL);

        Thread.sleep(2000);

        driver.close();
    }
}
