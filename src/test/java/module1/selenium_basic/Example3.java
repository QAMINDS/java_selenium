package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Example3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get("https://google.com");
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.get("https://facebook.com");
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.get("https://espn.com");
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("URL: " + driver.getCurrentUrl());
        if(driver.getCurrentUrl().equals("https://www.facebook.com/")){
            System.out.println("We are currently in Facebook homepage!!");
        }
        else{
            System.out.println("Something went wrong :(");
        }
        driver.navigate().refresh();
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.quit();

    }
}