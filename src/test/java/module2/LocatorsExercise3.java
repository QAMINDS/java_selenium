package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsExercise3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.nasa.gov");
        WebElement missions = driver.findElement(By.linkText("Missions"));
        System.out.println(missions.getAttribute("href"));

        WebElement tv = driver.findElement(By.linkText("NASA TV"));
        System.out.println(tv.getAttribute("href"));

        List<WebElement> tag = driver.findElements(By.tagName("input"));
        for(WebElement tags: tag){
            System.out.println(tags.getAttribute("value"));
        }

        driver.close();

    }
}

