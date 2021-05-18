package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsExercise7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        final String tiktok = " https://www.tiktok.com/?lang=es";
        String searchTopic = "Selenium";

        driver.get(tiktok);

        WebElement searchBox = driver.findElement(By.xpath("//*[@type=\"search\"]"));
        searchBox.sendKeys(searchTopic + Keys.ENTER);

        System.out.println("\nBúsqueda: " + "'" + searchTopic + "'"
                + "\nUsuarios encontrados:");

        List<WebElement> users = driver.findElements(By.xpath("//a[contains(@class, 'result-item')]"));
        for (int i = 0; i < users.size(); i++) {

            WebElement title = users.get(i).findElement(By.xpath(".//*[contains(@class, 'title ')]"));
            WebElement subtitle = users.get(i).findElement(By.xpath(".//*[contains(@class, 'sub-title')]"));
            WebElement description = users.get(i).findElement(By.xpath(".//*[contains(@class, 'desc')]"));

            System.out.println("    Usuario " + (i + 1) + ":\n"
                    + "        título: " + title.getText()
                    + "\n        subtítulo: " + subtitle.getText()
                    + "\n        descripción: " + description.getText());

        }
        driver.close();
    }
}
