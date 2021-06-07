package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandsOn1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx");
        WebElement searchBox = driver.findElement(By.name("field-keywords"));
        searchBox.sendKeys("Nintendo Switch");
        searchBox.sendKeys(Keys.ENTER);

//        WebElement checkbox = driver.findElement(By.xpath("//*[@id='brandsRefinements']//*contains(@id, 'Nintendo')]//span"));
        WebElement checkbox = driver.findElement(By.xpath("//li[@id='p_89/Nintendo']//i[@class='a-icon a-icon-checkbox']"));
        checkbox.click();

        WebElement stars = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']"));
        stars.click();

        WebElement sort = driver.findElement(By.id("s-result-sort-select"));
        Select sortSelect = new Select(sort);
        sortSelect.selectByValue("price-asc-rank");

//        WebElement drop = driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']"));
//        drop.click();
//
//        WebElement lower = driver.findElement(By.xpath("//a[normalize-space()='Precio: de más bajo a más alto']"));
//        lower.click();

        List<WebElement> results = driver.findElements(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[@class='s-desktop-width-max s-opposite-dir']/div[@class='s-desktop-content s-opposite-dir sg-row']/div[@class='s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16']/div[@class='sg-col-inner']/span[@class='rush-component s-latency-cf-section']/div[@class='s-main-slot s-result-list s-search-results sg-row']/div[2]/div[1]/div[1]"));
        for (WebElement result : results){
            WebElement title = result.findElement(By.xpath(".//*[contains(@class, 'a-size-medium a-color-base a-text-normal')]"));
            WebElement price = result.findElement(By.xpath(".//*[contains(@class, 'a-price-whole')]"));
            System.out.println("----------------------------");
            System.out.println(title.getText());
            System.out.println(price.getText());
//
        }

        // //button[contains(@class, 'search-button-container')]
//        WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
//        searchBtn.click();
//
//        List<WebElement> results = driver.findElements(By.xpath("//a[contains(@class, 'result-item')]"));
//        for (WebElement result : results) {
//            // Complex xpath: .//*[contains(@class, 'title') and not(contains(@class, 'sub'))]
//            WebElement title = result.findElement(By.xpath(".//*[contains(@class, 'title ')]"));
//            WebElement subTitle = result.findElement(By.xpath(".//*[contains(@class, 'sub-title')]"));
//            WebElement description = result.findElement(By.xpath(".//*[contains(@class, 'desc')]"));
//            System.out.println("----------------------------");
//            System.out.println(title.getText());
//            System.out.println(subTitle.getText());
//            System.out.println(description.getText());
//        }
//        driver.close();
    }
}
