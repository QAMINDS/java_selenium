package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverFactoryExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.close();
        driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.close();
    }
}
