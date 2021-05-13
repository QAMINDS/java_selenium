package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SeleniumExercise5_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.google.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        if(driver.getCurrentUrl().equals("https://www.google.com/")){
            System.out.println(" Pagina actual google: True");
        }else{
            System.out.println(" Pagina actual google: False");
        }

        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("Selenium");
        searchTextBox.sendKeys(Keys.ENTER);

        driver.close();
    }
}
