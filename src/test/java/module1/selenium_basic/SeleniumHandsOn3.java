package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHandsOn3 {
    public static void main(String[] args) throws InterruptedException {

        final String facebookURL = "https://www.facebook.com/";

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        driver.get(facebookURL);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("fake@fake.fake");

        WebElement pwdField = driver.findElement(By.id("pass"));
        pwdField.sendKeys("pwd");

        WebElement LogInButton = driver.findElement(By.name("login"));
        LogInButton.click();

        Thread.sleep(5000);

        driver.close();

    }
}
