package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Example2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get("https://google.com");
        String sourcecode = driver.getPageSource();
        //driver.get("https://saucelabs.com/resources/articles/selenium-grid");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Page Source:" + driver.getPageSource());
        driver.close();

        String[] arrSplit_3 = sourcecode.split("function");
        System.out.println("Frecuencia de funcion: "+arrSplit_3.length);


    }
}
