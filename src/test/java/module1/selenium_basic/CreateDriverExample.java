package module1.selenium_basic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class CreateDriverExample {

    public static void main(String[] args) {
       WebDriver driver = getFirefoxDriver();
       driver.get("https://www.google.com/");
       driver.close();

       driver = getChromeDriver();
       driver.get("https://www.google.com/");
       driver.close();
    }

    private static WebDriver getFirefoxDriver() {
        File root = new File("src/main/resources/drivers/windows");
        File firefoxFile = new File(root, "geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", firefoxFile.getPath());
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        File root = new File("src/main/resources/drivers/windows");
        File chromeFile = new File(root, "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFile.getPath());
        return new ChromeDriver();
    }
}
