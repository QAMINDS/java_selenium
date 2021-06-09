package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonPage {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");
        search(driver, "Nintendo Switch");
        applyFilters(driver);
        printProducts(driver);
        driver.close();
    }
    public static void search(WebDriver driver, String product) {
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchInput.sendKeys(product);
        searchBtn.click();
    }
    public static void applyFilters(WebDriver driver) {
        WebElement nintendo = driver.findElement(By.xpath("//*[contains(@id,'Nintendo') and not (contains(@id, 'Switch'))]/span"));
        nintendo.click();
        WebElement stars = driver.findElement(By.xpath("//*[@id='reviewsRefinements']//i[contains(@class, 'a-star') and contains(@class, '4')]"));
        stars.click();
        WebElement sort = driver.findElement(By.id("s-result-sort-select"));
        Select sortSelect = new Select(sort);
        sortSelect.selectByValue("price-asc-rank");
    }
    public static void printProducts(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> results = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@data-component-type='s-search-result']"), 5));
        for (WebElement result: results) {
            printProduct(result);
        }
    }
    public static void printProduct(WebElement root) {
        System.out.println("---------------------------------------------------");
        WebElement title = root.findElement(By.xpath(".//h2"));
        WebElement reviews = root.findElement(By.xpath(".//*[@class='a-size-base']"));
        List<WebElement> prices = root.findElements(By.xpath(".//*[@class='a-price']"));
        System.out.println("Title: " + title.getText());
        System.out.println("Reviews: " + reviews.getText());
        if (prices.size() > 0) {
            System.out.println("Price: " + prices.get(0).getText().trim());
        }
    }
}
