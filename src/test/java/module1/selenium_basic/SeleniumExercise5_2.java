package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SeleniumExercise5_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys("enrique@correo.com");
        WebElement passTextBox = driver.findElement(By.id("pass"));
        passTextBox.sendKeys("enrique@correo.com");
        WebElement loginBtn = driver.findElement(By.name("login"));
        loginBtn.click();
        Thread.sleep(5000);

        driver.close();
    }
}
