package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HandsOn4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.amazon.com.mx/");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(10000);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        search.sendKeys("selenium");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(10000);

        driver.close();
    }
}
