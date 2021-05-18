package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsExercise6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        final String tokio2020 = " https://olympics.com/tokyo-2020/es/";
        driver.get(tokio2020);


        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();

        Thread.sleep(2000);
/*
        //works
        WebElement language = driver.findElement(By.xpath("//button[@id='tk-languageButton-header']"));
        language.click();

        //works
        WebElement logo = driver.findElement(By.xpath("//a[@class='tk-emblem__link']"));
        logo.click();
*/

        WebElement registry = driver.findElement(By.xpath("//a[@class='tk-secondary-nav__link' and @data-jshook=\"gigya-signup\"]//span[position()=2]"));
        registry.click();


        Thread.sleep(2000);

        driver.close();

    }
}
