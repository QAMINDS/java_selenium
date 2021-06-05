package saucelabs.pages

import common.BasePage
import org.openqa.selenium.WebDriver
import saucelabs.elements.ProductElementsKotlin

class ProductPage(driver: WebDriver, timeout: Int, url: String?) : BasePage(driver, timeout, url) {

    val elementsKotlin: ProductElementsKotlin = ProductElementsKotlin(driver, timeout)


    override fun waitUntilLoaded() {
        elementsKotlin.getProductTitle()
    }

    fun sortAtoZ() {
        elementsKotlin.sortAtoZ()?.let { it.click() }
    }



//    fun login(username: String, password: String) {
//        enterUsername(username)
//        enterPassword(password)
//        clickLoginButton()
//    }
//
//    fun enterUsername(username: String) {
//        elements.userNameEditText.sendKeys(username)
//    }
//
//    fun enterPassword(password: String) {
//        elements.passwordEditText.sendKeys(password)
//    }
//
//    fun clickLoginButton() {
//        elements.loginButton.click()
//    }
//
//    fun isUserValid(): Boolean {
//        return elements.errorMessage?.let {  false } ?: true
//    }
}