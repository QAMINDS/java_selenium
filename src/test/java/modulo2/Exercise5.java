package modulo2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");

        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(selectElement);
        select.isMultiple();

        List<WebElement> elements = select.getOptions();
        for(WebElement input: elements) {
            System.out.println(input.getText());


        }

        System.out.println("");
        select.selectByVisibleText("Electrónicos");

        WebElement option = select.getFirstSelectedOption();
        System.out.println(option.getText());
        System.out.println(option.getAttribute("value"));
        System.out.println(select.isMultiple());



        driver.close();

    }
}
