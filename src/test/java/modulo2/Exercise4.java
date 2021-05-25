package modulo2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

        WebElement url = driver.findElement(By.linkText("Portada"));
        //driver.findElement(url);
        System.out.println(url.getAttribute("href"));

        List<WebElement> paginas = driver.findElements(By.partialLinkText("Página"));
        for(WebElement input: paginas) {
            System.out.println(input.getText());
            System.out.println(input.getAttribute("href"));
        }

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for(WebElement input: buttons) {
            System.out.println(input.getText());
        }

        //WebElement button = driver.findElement(By.tagName("button"));


        driver.close();




    }
}
