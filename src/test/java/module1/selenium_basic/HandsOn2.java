package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HandsOn2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.google.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String currentURL = driver.getCurrentUrl();

        if (driver.getCurrentUrl().equals("https://www.google.com/")){
            System.out.println("You are in Google's page");
        }
        else{
            System.out.println("You are NOT in Google's page");
        }

        WebElement searchBar = driver.findElement(By.name("q"));

        searchBar.sendKeys("maps");

        searchBar.sendKeys(Keys.ENTER);

        driver.close();
    }


}
