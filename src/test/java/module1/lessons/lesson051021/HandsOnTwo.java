package module1.lessons.lesson051021;

import common.WebDriverFactory;
import module1.selenium_basic.SeleniumExercise1;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HandsOnTwo {

    private final static Logger logger = Logger.getLogger(SeleniumExercise1.class);


    public static void main(String[] args) throws InterruptedException {

//        handsOnTwoExcercise();
//        handsOnThreeExcercise();
//        handsOnFourExcercise();
        handsOnSixExcercise();
    }

    private static void handsOnTwoExcercise() {
        final String GOOGLE_URL = "https://www.google.com";
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get(GOOGLE_URL);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals(GOOGLE_URL);
        WebElement searchElement = driver.findElement(By.name("q"));
        searchElement.sendKeys("Appium");
        searchElement.sendKeys(Keys.ENTER);

        driver.close();
    }

    private static void handsOnThreeExcercise() {
        final String FACEBOOK_URL = "https://www.facebook.com";
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get(FACEBOOK_URL);

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("Appium@hotmail.com");

        WebElement passwordElement = driver.findElement(By.id("pass"));
        passwordElement.sendKeys("12345");

        WebElement loginButtonElement = driver.findElement(By.name("login"));
        loginButtonElement.click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//        driver.close();
    }

    private static void handsOnFourExcercise() throws InterruptedException {
        final String AMAZON_URL = "https://www.amazon.com.mx";
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get(AMAZON_URL);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);


        WebElement twoTabSearchTextBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        twoTabSearchTextBoxElement.sendKeys("Selenium");
        twoTabSearchTextBoxElement.sendKeys(Keys.ENTER);

        Thread.sleep(10000);
//        driver.close();
    }

    private static void handsOnSixExcercise() throws InterruptedException {
        final String WIKIPEDIA_URL = "https://www.wikipedia.org";
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get(WIKIPEDIA_URL);

        final String searchText = "selenium";

        WebElement searchElement = driver.findElement(By.id("searchInput"));
        searchElement.sendKeys(searchText);
        searchElement.sendKeys(Keys.ENTER);
        List<WebElement> pElements = driver.findElements(By.tagName("p"));

        List<WebElement> pMatches = pElements.stream().filter(t -> t.getText().contains(searchText)).collect(Collectors.toList());
        logger.debug(" search topic: " + searchText + "  pMatches: " + pMatches.size());

        List<WebElement> aElements = driver.findElements(By.tagName("a"));
        List<WebElement> aMatches = aElements.stream().filter(t -> t.getText().contains(searchText)).collect(Collectors.toList());
        aMatches.stream().limit(5).forEach(it ->
                driver.navigate().to(it.getAttribute("href"))
        );

    }
}
