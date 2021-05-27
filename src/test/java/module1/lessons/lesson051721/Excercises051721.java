package module1.lessons.lesson051721;

import common.WebDriverFactory;
import module1.selenium_basic.SeleniumExercise1;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Excercises051721 {

    private final static Logger logger = Logger.getLogger(SeleniumExercise1.class);


    public static void main(String[] args) throws InterruptedException {

//        handsOnTwoExcercise();
//        handsOnThreeExcercise();
//        handsOnFourExcercise();
        tikTokExcercise();
    }

    private static void handsOnTwoExcercise() {
        final String OLYMPICS_URL = "https://olympics.com/tokyo-2020/es/";
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get(OLYMPICS_URL);

//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals(OLYMPICS_URL);
        WebElement tokyoLogo = driver.findElement(By.xpath("//a[contains(@class, '-emblem']"));

        WebElement registro =
                driver.findElement(By.xpath("//a[contains(@class, 'tk-secondary-nav__link']/span[contains(@class,'secondary-nav' )]"));

        WebElement playNowButton =
                driver.findElement(By.xpath("//div[contains(@class, 'fanzonebanner']/a"));

        driver.close();
    }

    private static void tikTokExcercise() throws InterruptedException {
        final String OLYMPICS_URL = "https://www.tiktok.com/?lang=es";
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get(OLYMPICS_URL);

        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals(OLYMPICS_URL);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        List<WebElement> tiktokList = driver.findElements(By.xpath("//a[contains(@class, 'result-item')]"));

        for (WebElement tiktok: tiktokList) {

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
