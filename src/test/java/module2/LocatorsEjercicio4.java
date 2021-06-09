package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsEjercicio4 {
    public static void main (String [] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

        WebElement linkPortada = driver.findElement(By.linkText("Portada"));
        System.out.println(linkPortada.getAttribute("href"));

        List<WebElement> linksPortada = driver.findElements(By.partialLinkText("Página"));
        for(WebElement link: linksPortada) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }

        List<WebElement> btns = driver.findElements(By.tagName("button"));
        System.out.println("Botones econtrados "+btns.size());

        for(WebElement btn: btns) {
            System.out.println(btn.getText());
        }

        driver.close();
    }
}
