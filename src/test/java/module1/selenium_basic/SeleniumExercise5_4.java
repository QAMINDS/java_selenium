package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumExercise5_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.wikipedia.org/");


        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        WebElement searchTextBox = driver.findElement(By.name("search"));
        searchTextBox.sendKeys("Selenium");
        searchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(10000);


    int counter = 0;
        List<WebElement> pElements = driver.findElements(By.tagName("p"));
        for (WebElement tmp: pElements) {
            System.out.println(tmp.getText());
            if(tmp.getText().contains("Selenium")){
                counter++;

            }
        }
        System.out.println("Veces :" + counter);

        List<WebElement> aElements = driver.findElements(By.tagName("a"));
        for (WebElement tmp: aElements) {
            System.out.println(tmp.getAttribute("href"));
        }

        driver.close();
    }
}
