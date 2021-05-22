package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Activity1 {
    private static final String TOPIC = "selenium";

    public static void main(String[] args)  {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get("https://listado.mercadolibre.com.mx");

        WebElement searchBox = driver.findElement(By.name("as_word"));
        searchBox.sendKeys(TOPIC);

        WebElement searchBtn = driver.findElement(By.className("nav-search-btn"));
        searchBtn.click();

        List<WebElement> prices = driver.findElements(By.className("price-tag-fraction"));
        for(WebElement price: prices) {
            System.out.println(price.getText());
        }

        List<WebElement> image = driver.findElements(By.className("ui-search-result-image__element"));
        image.get(image.size()-1).click();
        driver.close();
    }
}
