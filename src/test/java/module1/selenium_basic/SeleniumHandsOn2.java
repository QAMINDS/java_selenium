package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        final String googleURL = "https://www.google.com/";

        driver.get(googleURL);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(currentURL, googleURL);

        WebElement searchTextBox = driver.findElement(By.name("q"));

        searchTextBox.sendKeys("QA Minds Lab" + Keys.ENTER);

        driver.close();

    }
}
