package module2;

import common.WebDriverFactory;
import jdk.swing.interop.SwingInterOpUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        final String mdoLibreMxURL = "https://www.mercadolibre.com.mx/";

        driver.get(mdoLibreMxURL);

        WebElement searchBox = driver.findElement(By.name("as_word"));
        searchBox.sendKeys("PS4");

        WebElement searchButton = driver.findElement(By.className("nav-search-btn"));
        searchButton.click();

/*
// inconsistent behavior
        WebElement orderBy = driver.findElement(By.xpath("//button[contains(text(),'Más relevantes')]"));
        orderBy.click();

        WebElement orderByPrice = driver.findElement(By.xpath("//div[contains(text(),'Menor precio')]"));
        orderByPrice.click();
*/

        List<WebElement> products = driver.findElements(By.className("ui-search-layout__item"));
        for (WebElement product : products) {

            String title = product.findElement(By.className("ui-search-item__title")).getText();
            System.out.println("Product: " + title);

            StringBuilder totalprice = new StringBuilder();

            totalprice.append(product.findElement(By.className("price-tag-fraction")).getText());

            try {
                totalprice.append(product.findElement(By.className("price-tag-decimal-separator")).getText());
            } catch (WebDriverException e) {
                System.out.print("");
            }

            try {
                totalprice.append(product.findElement(By.className("price-tag-cents")).getText());
            } catch (WebDriverException e) {
                System.out.print("");
            }

            System.out.println("Price: $" + totalprice + "\n");
        }


        WebElement firstimage = products.get(0).findElement(By.className("ui-search-result-image__element"));
        firstimage.click();

        Thread.sleep(3000);

        driver.close();

    }
}
