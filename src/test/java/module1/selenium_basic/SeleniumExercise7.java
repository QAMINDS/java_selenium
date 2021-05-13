package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Login en facebook

public class SeleniumExercise7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.facebook.com/");

        By emilLocator = By.id("email");
        By passLocator = By.id("pass");
        By btnLogin = By.name("login");

        driver.findElement(emilLocator).sendKeys("fespinoza@gmail.com");
        driver.findElement(passLocator).sendKeys("123456");
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);

        driver.close();



    }
}
