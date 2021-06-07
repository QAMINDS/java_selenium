package saucelabs.pages

import common.BasePage
import org.openqa.selenium.WebDriver
import saucelabs.elements.IndividualInventoryItemElements

class InventoryItemPage(driver: WebDriver, timeout: Int): BasePage(driver, timeout) {

    val elements = IndividualInventoryItemElements(driver, timeout)

    override fun waitUntilLoaded() {
        elements.getItemDetailsName()
        elements.getItemDetailsDescription()
        elements.getItemDetailsPrice()
    }

    fun getItemDetailsName(): String? {
        return elements.getItemDetailsName()?.text
    }

    fun getItemDetailsDescription(): String? {
        return elements.getItemDetailsDescription()?.text
    }

    fun getItemDetailsPrice(): String? {
        return elements.getItemDetailsPrice()?.text
    }

    fun navigatePreviousPage() {
        super.navigateToPreviousPage()
    }
}
