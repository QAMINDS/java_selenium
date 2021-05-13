package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandsOn5 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("reneduardoglez@gmail.com");
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("Reneduardo");
        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        search.sendKeys("QA Minds");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        driver.close();
    }



}
