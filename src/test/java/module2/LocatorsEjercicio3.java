package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsEjercicio3 {
    public static void main (String [] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.nasa.gov/");

        WebElement linkMission = driver.findElement(By.linkText("Missions"));
        System.out.println(linkMission.getAttribute("href"));

        WebElement linkNasa= driver.findElement(By.linkText("NASA TV"));
        System.out.println(linkNasa.getAttribute("href"));

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for(WebElement input: inputs) {
            System.out.println(input.getAttribute("value"));
        }

        driver.close();
    }

}
