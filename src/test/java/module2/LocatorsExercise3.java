package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsExercise3 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        final String nasaURL = "https://www.nasa.gov/";

        driver.get(nasaURL);

        WebElement dropdownMissions = driver.findElement(By.linkText("Missions"));
        System.out.println("href of Missions dropdpown: " + dropdownMissions.getAttribute("href"));

        WebElement dropdownNasaTV = driver.findElement(By.linkText("NASA TV"));
        System.out.println("href of Nasa TV link: " + dropdownNasaTV.getAttribute("href"));

        System.out.println("Inputs:");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (int i = 0; i < inputs.size(); i++) {

            System.out.println("    Value " + i + ": " + inputs.get(i).getAttribute("value"));
        }

        driver.close();

    }
}
