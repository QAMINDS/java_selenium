package module1.selenium_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class SeleniumExercise4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
       // WebDriver WebElement;

        System.setProperty("webdriver.chrome.driver","./src/main/resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");


        WebElement searchElement = driver.findElement(By.name("search_query"));
        System.out.println("Element is enabled: " + searchElement.isEnabled());
        System.out.println("Element is displayed: " + searchElement.isDisplayed());
        searchElement.sendKeys("Selenium");
        WebElement searchBtn = driver.findElement(By.id("search-icon-legacy"));
        searchBtn.click();
        driver.close();

    }
}
