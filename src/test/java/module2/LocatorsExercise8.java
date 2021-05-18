package module2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LocatorsExercise8 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        final String mlbURL = "https://www.mlb.com/es/standings";
        driver.get(mlbURL);


        System.out.println("Por favor seleccione una opción:"
                + "\n    1 para División"
                + "\n    2 para Liga"
                + "\n    3 para MLB");


        boolean selection1IsValid = false;

        while (selection1IsValid == false) {
            Scanner scan1 = new Scanner(System.in);
            String userSelection1 = scan1.nextLine();

            String regex1 = "[123]";
            Pattern p1 = Pattern.compile(regex1);

            if (!userSelection1.matches(regex1)) {
                System.out.println("Por favor seleccione una opción válida:"
                        + "\n    1 para División"
                        + "\n    2 para Liga"
                        + "\n    3 para MLB");
            } else {
                int selectionToInt1 = Integer.parseInt(userSelection1) - 1;
                controlDivision(driver, selectionToInt1);
                selection1IsValid = true;
            }
        }


        System.out.println("\nAhora, por favor seleccione una opción:"
                + "\n    1 para Estándar"
                + "\n    2 para Avanzado");


        boolean selection2IsValid = false;

        while (selection2IsValid == false) {
            Scanner scan2 = new Scanner(System.in);
            String userSelection2 = scan2.nextLine();

            String regex2 = "[12]";
            Pattern p2 = Pattern.compile(regex2);

            if (!userSelection2.matches(regex2)) {
                System.out.println("Por favor seleccione una opción válida:"
                        + "\n    1 para Estándar"
                        + "\n    2 para Avanzado");
            } else {
                int selectionToInt2 = Integer.parseInt(userSelection2);
                controlStdAdv(driver, selectionToInt2);
                selection2IsValid = true;
            }
        }

        teamsInfo(driver);


        driver.quit();
    }

    public static void controlDivision(WebDriver driver, int i) {
        WebElement pDropDown = driver.findElement(By.xpath("//div[@class='standings__sub-nav subNav regularSeasonSubNav']//select[@class='p-dropdown__standings-view-dropdown-element has-label-span']"));
        Select pDDBox = new Select(pDropDown);
        pDDBox.selectByIndex(i);

        List<WebElement> pDDBoxElements = pDDBox.getOptions();
        System.out.println("Usted ha seleccionado: " + pDDBoxElements.get(i).getText());
    }

    public static void controlStdAdv(WebDriver driver, int j) {
        WebElement buttonStandard = driver.findElement(By.xpath("//*[@data-value=\"standard\"]"));
        WebElement buttonAdvanced = driver.findElement(By.xpath("//*[@data-value=\"advanced\"]"));

        if (j == 1) {
            buttonStandard.click();

            System.out.println("Usted ha seleccionado: Estándar");
        } else if (j == 2) {
            buttonAdvanced.click();

            System.out.println("Usted ha seleccionado: Avanzado");
        }

    }

    public static void teamsInfo(WebDriver driver) {
        List<WebElement> teams = driver.findElements(By.xpath("//*[@class=\"team--name\"]//a[@class=\"team p-text-link--mlb\"]"));
        HashSet<String> teamsList = new HashSet();

        for (WebElement tmp : teams) {
            teamsList.add(tmp.getText());
        }

        System.out.println("\nLista de equipos:");

        Iterator itr = teamsList.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
