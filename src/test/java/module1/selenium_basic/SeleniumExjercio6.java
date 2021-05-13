package module1.selenium_basic;
import java.util.concurrent.TimeUnit;
import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// Search something in google

public class SeleniumExjercio6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.google.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String asserUrl = "https://www.google.com/";

        String url = driver.getCurrentUrl();
        assert url.equals(asserUrl): "Current url is not google";

        WebElement searchElement = driver.findElement(By.name("q"));
        searchElement.sendKeys("Selenium");
        searchElement.sendKeys(Keys.ENTER); //usar enter

        driver.close();
    }
}
