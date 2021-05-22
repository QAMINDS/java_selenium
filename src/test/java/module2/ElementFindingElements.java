package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementFindingElements {
    private static String TOPIC = "Selenium";

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mercadolibre.com.mx/");

        WebElement searchBox = driver.findElement(By.name("as_word"));
        searchBox.sendKeys(TOPIC);

        WebElement searchBtn = driver.findElement(By.className("nav-search-btn"));
        searchBtn.click();

        List<WebElement> layoutItems = driver.findElements(By.className("ui-search-layout__item"));

        for (WebElement item: layoutItems) {
            WebElement description = item.findElement(By.xpath(".//*[@class='ui-search-item__title ui-search-item__group__element']"));
            System.out.println(description.getText());
        }

        driver.close();
    }
}
