package module1.lessons.lesson051521

import common.WebDriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.lang.Exception
import java.util.concurrent.TimeUnit


fun main() {
//    excerciseTwo()
//    excerciseThree()
    excerciseFour()
}

fun excerciseTwo() {
    val GOOGLE_URL = "https://www.google.com.mx"
    val driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX)
    driver.get(GOOGLE_URL)
    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS)


    try {
        val twoTabSearchTextBoxElement = driver.findElement(By.id("JustAnInvalidID"))
    } catch (e: Exception) {
        e
    }
    driver.close()
}

fun excerciseThree() {
    val NASA_URL = "https://www.nasa.gov"
    val driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX)
    driver.get(NASA_URL)

    val missionLink = driver.findElement(By.linkText("Missions"))
    println(missionLink.getAttribute("href"))

    val nasaTv = driver.findElement(By.linkText("NASA TV"))
    println(nasaTv.getAttribute("href"))

    val inputElements = driver.findElements(By.tagName("input"))
    inputElements.forEach {  element ->
        println(element.getAttribute("value"))
    }
    driver.close()
}

fun excerciseFour() {
    val WIKIPEDIA_URL = "https://es.wikipedia.org/wiki/Portada"
    val driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME)
    driver.get(WIKIPEDIA_URL)

    val portadaLink = driver.findElement(By.linkText("Portada"))
    println(portadaLink.getAttribute("href"))

    val paginaLinks: List<WebElement> = driver.findElements(By.linkText("Pagina"))
    paginaLinks.forEach {  element ->
        println("  ${element.text}   ${element.getAttribute("href")}  ")
    }

//    val buttonElements = driver.findElements(By.tagName("button"))
    driver.findElements(By.tagName("button")).forEach {
        println(it.text)
    }

//    Thread.sleep(5000)
    driver.close()
}


