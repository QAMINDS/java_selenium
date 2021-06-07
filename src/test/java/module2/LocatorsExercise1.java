package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsExercise1 {
    private static final String TOPIC = "Selenium";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://listado.mercadolibre.com.mx");

        WebElement searchBox = driver.findElement(By.name("as_word"));
        searchBox.sendKeys(TOPIC);

        WebElement searchBtn = driver.findElement(By.className("nav-search-btn"));
        searchBtn.click();

        List<WebElement> prices = driver.findElements(By.className("price-tag-fraction"));
        prices.get(0).click();
        Thread.sleep(10000);

        driver.close();
    }
}
