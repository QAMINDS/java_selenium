package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TitokPage {
    public static void main (String [] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.tiktok.com/?lang=es");

        WebElement inputBuscar = driver.findElement(By.xpath("//input[@type='search'][@name='q']"));

        inputBuscar.sendKeys("Selenium");

        WebElement btnBuscar = driver.findElement(By.xpath("//button [@type='submit']"));
        btnBuscar.click();

        List<WebElement> usuarios =driver.findElements(By.xpath("//a[contains(@class,'result-item')]"));

        for(WebElement usuario: usuarios){
            System.out.println("-----------------------------------");
            WebElement title = usuario.findElement(By.xpath(".//*[contains(@class,'title ')]"));
            System.out.println("Title" +title.getText());
            WebElement subtitle = usuario.findElement(By.xpath(".//*[contains(@class,'sub-title')]"));
            System.out.println("subtitle" +subtitle.getText());
            WebElement desc = usuario.findElement(By.xpath(".//*[contains(@class,'desc')]"));
            System.out.println("desc" +title.getText());
        }

        driver.close();

    }
}
