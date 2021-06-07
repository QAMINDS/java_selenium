package saucelabs.elements

import common.BaseElement
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class ProductElementsKotlin(driver: WebDriver, timeout: Int): BaseElement(driver, timeout) {

    private val USER_NAME_TEXT = By.id("user-name")

    private val PASSWORD_TEXT = By.id("password")

    private val SORTING_OPTIONS = By.xpath("//*[@class='product_sort_container']/*")

    private val PRODUCT_TITLE = By.xpath("//*[@class='title']")


    fun getProductTitle(): WebElement {
        return this.waitUntilVisible(PRODUCT_TITLE)
    }

    fun getSortingOptions(): List<WebElement> {
        return this.waitForElements(SORTING_OPTIONS)
    }

    fun sortAtoZ(): WebElement? {
        return this.waitForElements(SORTING_OPTIONS).firstOrNull()
    }
}