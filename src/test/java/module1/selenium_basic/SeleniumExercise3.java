package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class SeleniumExercise3 {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);

        driver.get("https://www.google.com.mx/");
        System.out.println("URL --> "+driver.getCurrentUrl());

        driver.navigate().to("https://es-la.facebook.com/");
        System.out.println("URL --> "+driver.getCurrentUrl());

        Thread.sleep(1000);
        driver.close();
    }
}
