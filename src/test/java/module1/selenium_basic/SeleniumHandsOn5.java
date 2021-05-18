package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumHandsOn5 {
    public static void main(String[] args) throws InterruptedException {

        final String facebookURL = "https://www.facebook.com/";
        final String email = "";
        final String pwd = "";

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        driver.get(facebookURL);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);

        WebElement pwdField = driver.findElement(By.id("pass"));
        pwdField.sendKeys(pwd);

        WebElement LogInButton = driver.findElement(By.name("login"));
        LogInButton.click();

        Thread.sleep(10000);

        WebElement SearchField = driver.findElement(By.xpath("//input[@type = 'search']"));
        SearchField.sendKeys("QA Minds" + Keys.ENTER);


        Thread.sleep(10000);


        driver.close();


    }
}
