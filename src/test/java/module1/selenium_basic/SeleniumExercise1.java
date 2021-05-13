package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExercise1 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver","./src/main/resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        driver.close();

    }
}
