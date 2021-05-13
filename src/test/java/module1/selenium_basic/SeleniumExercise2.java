package module1.selenium_basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExercise2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver","./src/main/resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        String sourceCode = driver.getPageSource();

        System.out.println(title);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        Thread.sleep(1000);
        driver.close();

        String [] arrSplipt_2 = sourceCode.split("function");
        System.out.println("Frecuencia con que se repetie  la palabra funtion: " +arrSplipt_2.length);

        arrSplipt_2 = sourceCode.split("script");
        System.out.println("Frecuencia con que se repetie  la palabra script: " +arrSplipt_2.length);

        arrSplipt_2 = sourceCode.split("class");
        System.out.println("Frecuencia con que se repetie  la palabra class: " +arrSplipt_2.length);
    }
}
