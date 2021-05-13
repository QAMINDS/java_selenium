package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Exercise4 {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
            driver.get("https://www.youtube.com/");
            WebElement searchBar = driver.findElement(By.name("search_query"));
            System.out.println("Element is enabled: "+searchBar.isEnabled());
            System.out.println("Element is displayed: "+searchBar.isDisplayed());

            searchBar.sendKeys("selenium");

            WebElement iconLegacy =driver.findElement(By.id("search-icon-legacy"));
            iconLegacy.click();

            driver.close();
        }
}
