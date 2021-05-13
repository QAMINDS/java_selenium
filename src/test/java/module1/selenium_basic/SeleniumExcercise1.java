package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class SeleniumExcercise1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://google.com");
        Thread.sleep(1000);
        //driver.close();
    }
}
