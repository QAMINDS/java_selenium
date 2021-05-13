package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HandsOn3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("fakemail@gmail.com");

        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("Pwd123");

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        driver.close();
    }
}
