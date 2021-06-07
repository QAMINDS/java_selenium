package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TikTok {

    private static final String TOPIC = "Selenium";

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.tiktok.com/?lang=es");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(TOPIC);

        // //button[contains(@class, 'search-button-container')]
        WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        searchBtn.click();

        List<WebElement> results = driver.findElements(By.xpath("//a[contains(@class, 'result-item')]"));
        for (WebElement result : results) {
            // Complex xpath: .//*[contains(@class, 'title') and not(contains(@class, 'sub'))]
            WebElement title = result.findElement(By.xpath(".//*[contains(@class, 'title ')]"));
            WebElement subTitle = result.findElement(By.xpath(".//*[contains(@class, 'sub-title')]"));
            WebElement description = result.findElement(By.xpath(".//*[contains(@class, 'desc')]"));
            System.out.println("----------------------------");
            System.out.println(title.getText());
            System.out.println(subTitle.getText());
            System.out.println(description.getText());

        }
        driver.close();
    }
}
