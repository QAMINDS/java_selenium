package module1.selenium_basic;
import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class SeleniumExercise1 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);

        driver.get("https://www.google.com");
        String title = driver.getTitle();
        String sourceCode = driver.getPageSource();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        Thread.sleep(1000);
        driver.close();

        String[] arrSplit_3 = sourceCode.split("function");
        System.out.println("Frecuencia de function: "+arrSplit_3.length);

        arrSplit_3 = sourceCode.split("script");
        System.out.println("Frecuencia de script: "+arrSplit_3.length);

        arrSplit_3 = sourceCode.split("class");
        System.out.println("Frecuencia de class: "+arrSplit_3.length);

        arrSplit_3 = sourceCode.split("id");
        System.out.println("Frecuencia de id: "+arrSplit_3.length);
    }
}


//C:\Users\JETG\Documents\Selenium Webdriver\java_selenium\src\main\resources\drivers\windows
//C:\Users\JETG\Documents\Selenium Webdriver\              src\main\resources\drivers\windows\chromedriver.exe