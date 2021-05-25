package modulo2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Exercise9 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By searchBox = By.id("twotabsearchtextbox");
        By btnSearch = By.id("nav-search-submit-text");

        driver.findElement(searchBox).sendKeys("nintendo switch");
        driver.findElement(btnSearch).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@id='p_89/Nintendo']/span/a/div/label/i")).click();

        driver.close();

    }
}
