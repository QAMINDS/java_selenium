package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsExercise4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://es.wikipedia.org/wiki/Portada");
        WebElement portada = driver.findElement(By.linkText("Portada"));
        System.out.println("Link con portada: " + portada.getAttribute("href"));

        List <WebElement> pagina = driver.findElements(By.partialLinkText("página"));
        for(WebElement pags: pagina){
            System.out.println("Texto con página: " + pags.getText());
            System.out.println("Links con página: " + pags.getAttribute("href"));
        }

        List <WebElement> button = driver.findElements(By.tagName("button"));
        for(WebElement btn: button){
            System.out.println("Elementos con button: " + btn.getText());
        }

    }
}
