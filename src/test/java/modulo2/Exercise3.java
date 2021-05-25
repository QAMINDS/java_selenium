package modulo2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


       // By url = By.linkText("Missions");

        driver.get(" https://www.nasa.gov/");

        WebElement url = driver.findElement(By.linkText("Missions"));
        //driver.findElement(url);
        System.out.println(url.getAttribute("href"));

        WebElement url2 = driver.findElement(By.linkText("NASA TV"));
        System.out.println(url2.getAttribute("href"));

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for(WebElement input: inputs) {
            System.out.println(input.getAttribute("value"));
        }

        driver.close();




    }
}
