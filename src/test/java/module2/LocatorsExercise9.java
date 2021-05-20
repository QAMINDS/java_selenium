package module2;

import common.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LocatorsExercise9 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        final String amazonMxURL = "https://www.amazon.com.mx/";
        String searchCriteria = "Nintendo Switch";

        driver.get(amazonMxURL);

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#twotabsearchtextbox")));
        searchBox.sendKeys(searchCriteria + Keys.ENTER);

        WebElement nintendoBrandFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id, 'Nintendo')and not(contains(@id,'Switch'))]//i[@class='a-icon a-icon-checkbox']")));
        nintendoBrandFilter.click();

        WebElement _4starsFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='reviewsRefinements']//i[contains(@class, '4')]")));
        _4starsFilter.click();

        WebElement OrderBy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='a-native-dropdown a-declarative']")));
        Select dropDownOrderBy = new Select(OrderBy);
        dropDownOrderBy.selectByValue("price-asc-rank");


        System.out.println("\nResultados de búsqueda: '" + searchCriteria + "'");
        getPriceList(wait);


        driver.close();
    }

    public static void getPriceList(WebDriverWait wait) {
        List<WebElement> searchResults = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@data-component-type='s-search-result']"), 10));
        for (int i = 0; i < searchResults.size(); i++) {

            System.out.println("\nProducto " + (i + 1));

            WebElement title = searchResults.get(i).findElement(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
            System.out.println("    Nombre: " + title.getText());

            WebElement rating = searchResults.get(i).findElement(By.xpath(".//span[@class='a-icon-alt']"));
            WebElement reviews = searchResults.get(i).findElement(By.xpath(".//span[@class='a-size-base']"));
            System.out.println("    Rating: " + rating.getAttribute("textContent") + "; con " + reviews.getText() + " reviews");

            List<WebElement> prices = searchResults.get(i).findElements(By.xpath(".//span[@class='a-price']//span[@class='a-offscreen']"));
            List<WebElement> deliveryCharges = searchResults.get(i).findElements(By.xpath(".//span[contains(text(), 'envío')]"));
            if (prices.size() == 0) {
                System.out.println("    Precio no disponible");
            } else if (deliveryCharges.size() == 0) {
                System.out.println("    Precio: " + prices.get(0).getAttribute("textContent"));
            } else {
                System.out.println("    Precio: " + prices.get(0).getAttribute("textContent") + " (mas " + deliveryCharges.get(0).getAttribute("textContent") + ")");
            }

            List<WebElement> arePrime = searchResults.get(i).findElements(By.xpath(".//span[@class='aok-inline-block s-image-logo-view']"));
            if (arePrime.size()>0){
                System.out.println("    ✓ Prime");
            }

            List<WebElement> areImports = searchResults.get(i).findElements(By.xpath(".//div[@class='a-row a-size-base a-color-secondary']//img[contains(@src, 'https://www.amazon.com.mx/images/I/')]"));
            if (areImports.size()>0){
                System.out.print("    ");
                System.out.println("⚠ Importación");
            }
        }
    }
}
