package module1.lessons.lesson051921;

import common.WebDriverFactory;
import module1.selenium_basic.SeleniumExercise1;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Excercise051921 {

    private final static Logger logger = Logger.getLogger(SeleniumExercise1.class);


    public static void main(String[] args) throws InterruptedException {

        amazonNintendoSearch();
    }

    private static void amazonNintendoSearch() throws InterruptedException {
        final String AMAZON_URL = "https://www.amazon.com.mx";
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get(AMAZON_URL);

        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals(AMAZON_URL);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nintendo Switch");

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();


        Thread.sleep(3000);
        List<WebElement> brandList = driver.findElements(By.xpath("//ul[contains(@class, 'a-unordered-list a-nostyle a-vertical a-spacing-medium')]/li"));

        for (WebElement tiktok: brandList) {

            WebElement title = tiktok.findElement(By.xpath(".//*[contains(@class, 'title'))]"));
            System.out.println(" Title: " + title.getText());
            WebElement subtitle = tiktok.findElement(By.xpath(".//*[contains(@class, 'sub-title'))]/h2"));
            System.out.println(" Subtitle: " + title.getText());

            WebElement description = tiktok.findElement(By.xpath(".//*[contains(@class, 'desc'))]"));
            System.out.println(" Description: " + description.getText());


        }



        driver.close();
    }
}
