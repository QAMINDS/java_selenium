package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class SeleniumExercise1 {

    public static void main (String [] args) throws InterruptedException{

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);

        driver.get("https://www.google.com.mx/");
        Thread.sleep(1000);
        driver.close();
    }
}
