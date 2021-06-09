package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class SeleniumExercise2 {
    public static void main (String [] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.google.com.mx/");

        System.out.println("Title --> "+driver.getTitle());
        System.out.println("URL --> "+driver.getCurrentUrl());

        String pageSource = driver.getPageSource();

       // System.out.println("Source --> "+pageSource);

       int function=0, script=0,numClass=0, id=0;

        String[] words = pageSource.split("\\s+");
        System.out.println("class "+numClass);
        System.out.println("function "+function);
        System.out.println("script "+script);
        System.out.println("id "+id);

       driver.close();
    }
}
