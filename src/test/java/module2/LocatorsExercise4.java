package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsExercise4 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        final String wikipediaPortada = "https://es.wikipedia.org/wiki/Portada";
        driver.get(wikipediaPortada);

        WebElement linkPortada = driver.findElement(By.linkText("Portada"));
        System.out.println("1er link con texto 'Portada': " + linkPortada.getAttribute("href"));

        System.out.println("Links con texto 'Página':");
        List<WebElement> linksPagina = driver.findElements(By.partialLinkText("Página"));
        for (int i = 0; i < linksPagina.size(); i++) {
            System.out.println("    " + ( i + 1) + ": '" + linksPagina.get(i).getText() + "' Link: " + linksPagina.get(i).getAttribute("href"));
        }

        System.out.println("Botones con texto:");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (int i = 0; i < buttons.size(); i++) {
            System.out.println("    " + buttons.get(i).getText());
        }

        driver.close();
    }
}
