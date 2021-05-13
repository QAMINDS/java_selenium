package module1.selenium_basic;

import common.WebDriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumExercise1 {
    private final static Logger logger = Logger.getLogger(SeleniumExercise1.class);


    public static void main(String[] args) throws InterruptedException {

//        String sourceCode = firstExcercise();
//        secondExcercise(sourceCode);
//        thirdExcercise();

        fifthExcercise();

    }

    private static String firstExcercise() {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        String sourceCode = driver.getPageSource();

        System.out.println(" Title: " + title);
        System.out.println(" Url: " + url);

        System.out.println(" Source code: " + sourceCode);
        logger.debug(" Title: " + title);
        logger.debug(" url: " + url);

//        driver.navigate();
        return sourceCode;
    }

    private static void secondExcercise(String sourceCode) {

    }

    private static void thirdExcercise() {
        final String facebookUrl = "https://www.facebook.com/";

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        WebDriver.Navigation navigation = driver.navigate();
        driver.get("https://www.google.com");
        String firstUrl = driver.getCurrentUrl();
        System.out.println(" First url: " + firstUrl);
        logger.debug(" First url: " + firstUrl);

        driver.navigate().to(facebookUrl);
        String secondUrl = driver.getCurrentUrl();
        System.out.println(" Second url: " + secondUrl);
        logger.debug(" Second url: " + secondUrl);

        driver.navigate().to("https://www.espn.com/");
        String thirdUrl = driver.getCurrentUrl();
        System.out.println(" Third url: " + thirdUrl);
        logger.debug(" Third url: " + thirdUrl);

        driver.navigate().back();
        driver.navigate().back();
        String fourthUrl = driver.getCurrentUrl();
        System.out.println(" Fourth url: " + fourthUrl);
        logger.debug(" Fourth url: " + fourthUrl);

        navigation.forward();
        String fifthUrl = driver.getCurrentUrl();
        System.out.println(" Fifth url: " + fifthUrl);
        logger.debug(" Fifth url: " + fifthUrl);

        assert fifthUrl.equals(facebookUrl) : "Current url is not facebook";
        navigation.refresh();

        String sixthUrl = driver.getCurrentUrl();
        System.out.println(" Sixth url: " + sixthUrl);
        logger.debug(" Sixth url: " + sixthUrl);
        driver.close();

    }

    private static void fifthExcercise() throws InterruptedException {
        final String youtubeUrl = "https://www.youtube.com/";
        final String SEARCH_KEY = "Selenium";

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);

        navigateTo(driver, youtubeUrl);

        WebElement searchElement = driver.findElement(By.name("search_query"));
        if (searchElement.isDisplayed() && searchElement.isEnabled()) {
            System.out.println(" element " + searchElement.getTagName() + " is displayed and enabled.");
            searchElement.sendKeys(SEARCH_KEY);
        } else {
            System.out.println(" element " + searchElement.getTagName() + " is NOT displayed.");
        }

        WebElement searchElementButton = driver.findElement(By.id("search-icon-legacy"));
        searchElementButton.click();

        Thread.sleep(5000);


    }

    private static void navigateTo(WebDriver driver, String url) {
        driver.navigate().to(url);
        String thirdUrl = driver.getCurrentUrl();
        System.out.println(" url: " + thirdUrl);
        logger.debug(" url: " + thirdUrl);
    }
}
