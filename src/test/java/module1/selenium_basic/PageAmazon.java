package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageAmazon {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.amazon.com.mx/");

        Thread.sleep(10000);

        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("Selenium");

        element = driver.findElement(By.id("nav-search-submit-text"));
        element.click();

        Thread.sleep(5000);
        driver.close();


    }
}
