package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class SeleniumExercise4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        mainTestCase(driver);
    }

    public static void mainTestCase(WebDriver driver) {
        driver.get("https://www.youtube.com/");

        WebElement searchElement = driver.findElement(By.name("search_query"));
        System.out.println("Element is enabled: " + searchElement.isEnabled());
        System.out.println("Element is displayed: " + searchElement.isDisplayed());
        searchElement.sendKeys("Selenium");
        searchElement.sendKeys(Keys.ENTER);

        List<WebElement> pElements = driver.findElements(By.tagName("p"));

        List<WebElement> aElements = driver.findElements(By.xpath("//input[@type=\"search\"]"));
        for (WebElement tmp: pElements) {
            System.out.println(tmp.getText().contains("Selenium"));
        }

        getHyperlinkInfo(driver);

        WebElement searchBtn = driver.findElement(By.id("search-icon-legacy"));
        searchBtn.click();
        driver.close();


    }

    public static void getHyperlinkInfo(WebDriver driver) {
        List<WebElement> aElements = driver.findElements(By.tagName("a"));
        for (WebElement tmp: aElements) {
            System.out.println(tmp.getAttribute("href"));
        }
    }
}
