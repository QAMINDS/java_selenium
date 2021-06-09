package module2;
import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EjercicioSelect {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");
        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Electrónicos");
       /* WebElement option = select.getFirstSelectedOption();
        System.out.println(option.getText());
        System.out.println(option.getAttribute("value"));*/

        List<WebElement> options  = select.getOptions();

        for(WebElement option :options){
            System.out.println(option.getText());
        }

        System.out.println("Select es opcion multiple: "+select.isMultiple());


        driver.close();
    }
}
