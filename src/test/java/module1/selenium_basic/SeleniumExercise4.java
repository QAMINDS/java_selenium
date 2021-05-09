package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumExercise4 {

    private static WebElement searchBox;
    private static WebElement searchButton;

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        String youtubeURL = "https://www.youtube.com";
        driver.get(youtubeURL);


        boolean isSrchBxPresent = true;

        try {
            searchBox = driver.findElement(By.name("search_query"));
        } catch (NoSuchElementException e) {
            System.out.println("Search box not found");
            isSrchBxPresent = false;
        }


        if (isSrchBxPresent) {
            boolean isDisplayed = searchBox.isDisplayed();
            boolean isEnabled = searchBox.isEnabled();

            if (isDisplayed && isEnabled) {
                searchBox.sendKeys("Selenium");
            } else {
                System.out.println("Missing or disabled element");
            }
        }


        boolean isSrchBttnPresent = true;

        try {
            searchButton = driver.findElement(By.id("search-icon-legacy"));
        } catch (NoSuchElementException e) {
            System.out.println("Search button not found");
            isSrchBttnPresent = false;
        }


        if (isSrchBttnPresent) {
            searchButton.click();
        }

        Thread.sleep(5000);


        try {
            WebElement found = driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'Automatización de Pruebas con Selenium WebDriver +')]"));
        } catch (NoSuchElementException e) {
            System.out.println("No results found");
        }


        driver.close();

    }
}
