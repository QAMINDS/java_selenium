package module2;

import common.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorsExercise6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        final String tokio2020URL = " https://olympics.com/tokyo-2020/es/";
        driver.get(tokio2020URL);


        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();


        WebElement registry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='tk-secondary-nav__link' and @data-jshook=\"gigya-signup\"]//span[position()=2]")));
        registry.click();

        WebElement closeRegistry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='gigya-composite-control gigya-composite-control-link wm-nav wm-nav-close' and contains(text(),'Cerrar')]")));
        closeRegistry.click();


        WebElement language = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='tk-languageButton-header']")));
        language.click();


        WebElement searchBtn = driver.findElement(By.xpath("//button/span[@class='tk-icon-search']"));
        searchBtn.click();

        WebElement closeSearch = driver.findElement(By.xpath("//span[@class='tk-search-box__close tk-icon-close']"));
        closeSearch.click();


        WebElement tokyoLogo = driver.findElement(By.xpath("//a[@class='tk-emblem__link']"));
        tokyoLogo.click();


        WebElement playNow = driver.findElement(By.xpath("//*[@id='tk-fanzonebanner__banner--standard']/div/a"));
        playNow.click();


        WebElement hMenu = driver.findElement(By.xpath(" //*[@class=\"tk-main-nav__menu-icon\"]"));
        hMenu.click();


        driver.quit();
    }
}
