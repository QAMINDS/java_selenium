package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LocatorsExercise5 {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        final String amazonMxURL = "https://www.amazon.com.mx/";
        driver.get(amazonMxURL);

        WebElement searchDropDown = driver.findElement(By.id("searchDropdownBox"));
        Select searchDDBox = new Select(searchDropDown);

        List<WebElement> srchDDBoxElements = searchDDBox.getOptions();

        System.out.println("Departamentos: ");

        for (int i = 0; i < srchDDBoxElements.size(); i++) {

            System.out.println(i + 1 + ": " + srchDDBoxElements.get(i).getText());
        }

        System.out.println("\nEs múltiple? (Se puede seleccionar más de un elemento a la vez?) " + searchDDBox.isMultiple());

        System.out.println("\nPrimera opción seleccionada: " + searchDDBox.getFirstSelectedOption().getText());

       searchDDBox.selectByIndex(4);
       Thread.sleep(2000);

       searchDDBox.selectByValue("search-alias=automotive");
        Thread.sleep(2000);


        driver.close();

    }
}
