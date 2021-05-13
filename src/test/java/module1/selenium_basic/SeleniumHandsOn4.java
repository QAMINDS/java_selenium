package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn4 {
    public static void main(String[] args) throws InterruptedException {

        final String amazonMxURL = "https://www.amazon.com.mx/";

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        driver.get(amazonMxURL);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("Selenium");

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        Thread.sleep(10000);

        driver.close();

    }
}
