package module1.selenium_basic;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.WebDriverFactory;

public class SeleniumExercise3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        String asserUrl = "https://www.facebook.com/";


        System.setProperty("webdriver.chrome.driver","./src/main/resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        String Url1 = driver.getCurrentUrl();
        System.out.println("la primera url es: " +Url1 );

        driver.navigate().to("https://www.facebook.com/");
        String url2 = driver.getCurrentUrl();
        System.out.println("la segunda  url es: " + url2);


        driver.navigate().to("https://espndeportes.espn.com/");

        driver.navigate().back();
        driver.navigate().back();
        String url3 = driver.getCurrentUrl();
        System.out.println("la url 2es: "+ url3);

        driver.navigate().forward();
        String url4 = driver.getCurrentUrl();
        System.out.println("la url4 es: "+ url4);


        assert url4.equals(asserUrl): "Current url is not facebook";
        driver.navigate().refresh();

        driver.close();





        Thread.sleep(1000);
        driver.close();


    }
}
