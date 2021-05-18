package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LocatorsExercise2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS.SECONDS);

        final String googleURL = "https://www.google.com.mx/";
        driver.get(googleURL);

        WebElement invalid = driver.findElement(By.id("invalid"));

    }
}
