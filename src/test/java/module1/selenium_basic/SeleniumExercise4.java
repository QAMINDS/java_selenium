package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumExercise4 {

    public static void main (String [] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        driver.get("https://www.youtube.com/");

        WebElement element = driver.findElement(By.name("search_query"));

        if(element.isDisplayed() && element.isEnabled()){
            element.sendKeys("Selenium");
        }else{
            throw new InvalidArgumentException("El elmento no esta habilitado o visible");
        }

        element = driver.findElement(By.id("search-icon-legacy"));
        element.click();

        Thread.sleep(5000);
        driver.close();
    }
}
