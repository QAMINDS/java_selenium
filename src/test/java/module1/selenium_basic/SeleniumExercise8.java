package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SeleniumExercise8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.amazon.com/-/es/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By searchBox = By.id("twotabsearchtextbox");
        By btnSearch = By.id("nav-search-submit-text");
        By textLocator = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");


        driver.findElement(searchBox).sendKeys("Selenium");
        driver.findElement(btnSearch).click();
       // searchBox.sendKeys(Keys.ENTER); //usar enter
       /// Assert.assertEquals(true, true, "It should be equal");
        driver.close();


    }
}
