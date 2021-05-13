package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageFacebook {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys("qamindstester@gmail.com");

        element = driver.findElement(By.id("pass"));
        element.sendKeys("Q@Minds4%");

        element = driver.findElement(By.name("login"));
        element.click();

        Thread.sleep(5000);

        driver.close();

    }
}
