package modulo2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Exercise1 {
    private static final String TOPIC = "selenium" ;

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("https://www.mercadolibre.com.mx/");

        WebElement searchBox = driver.findElement(By.name("as_word"));
        searchBox.sendKeys(TOPIC);
        WebElement searchBtn = driver.findElement(By.className("nav-search-btn"));
        searchBtn.click();
        List<WebElement> prices = driver.findElements(By.className("price-tag-fraction"));
        for(WebElement price: prices) {
            System.out.println(price.getText());
        }
        List<WebElement> images = driver.findElements(By.className("ui-search-result-image__element"));
        images.get(0).click();
        driver.close();


    }
}
