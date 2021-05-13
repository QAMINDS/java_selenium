package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumExercise5_5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.facebook.com/");

        String password = "Q@Minds4%";

        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys("qamindstester@gmail.com");
        WebElement passTextBox = driver.findElement(By.id("pass"));
        passTextBox.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.name("login"));
        loginBtn.click();
        Thread.sleep(10000);

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@type = 'search']"));
        searchTextBox.sendKeys("QA Minds");
        searchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        driver.close();
    }
}
