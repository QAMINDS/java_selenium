package module1.selenium_basic;


import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;


public class SeleniumExercise2 {
    public static void main(String[] args) throws InterruptedException {
        File root = new File("src/main/resources/drivers/windows");
        File firefoxFile = new File(root, "geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", firefoxFile.getPath());


        WebDriver driver = new PerfTrackerBrowser();
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        driver.get("https://www.youtube.com");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.close();
    }
}

class PerfTrackerBrowser extends FirefoxDriver {
    @Override
    public void get(String url) {
        long startTime = System.nanoTime();
        super.get(url);
        long duration = (System.nanoTime() - startTime) / 1000000 ;
        System.out.println(String.format("[GET] %s: %s ms", url, String.valueOf(duration)));
    }
}