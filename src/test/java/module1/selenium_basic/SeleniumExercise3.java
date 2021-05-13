package module1.selenium_basic;
import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;

/*
Launch firefox/chrome browser
Get google main page and print current url
Move to facebook page and print current url
Move to ESPN page and print current url
Move backward twice and print current url
Move forward once and print current url
assert that the current URL is Facebook page
Refresh and print current url
Close browser
* */

public class SeleniumExercise3 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);

        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());

        driver.get("https://www.fb.com");
        System.out.println(driver.getCurrentUrl());

        driver.get("https://www.espn.com");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().back();

        if(driver.getCurrentUrl() == "https://www.facebook.com/"){
            System.out.println(" Pagina actual FB: True");
        }else{
            System.out.println(" Pagina actual FB: False");
        }

        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(1000);
        driver.close();
    }
}
