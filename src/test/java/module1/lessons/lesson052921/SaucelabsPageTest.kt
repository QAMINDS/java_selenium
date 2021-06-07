package module1.lessons.lesson052921

import common.BaseTestMultiThread
import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import saucelabs.pages.SaucelabsKotlin

class SaucelabsPageTest: BaseTestMultiThread(){

    lateinit var saucelabsPage: SaucelabsKotlin

    @DataProvider(name = VALID_USER_PROVIDER)
    fun validUserDataProvider(): Array<Array<Any>> {
        return arrayOf(
            arrayOf(STANDARD_USER, PASSWORD),
            arrayOf(PROBLEM_USER, PASSWORD)
        )
    }

    @DataProvider(name = INVALID_USER_PROVIDER)
    fun invalidUserDataProvider(): Array<Array<Any>> {
        return arrayOf(
            arrayOf(STANDARD_USER, WRONG_PASSWORD)
        )
    }

    @Test(groups = ["sanity"], dataProvider = VALID_USER_PROVIDER)
    fun `when logging in with correct credentials should be able to login`(username: String, password: String) {
        val saucelabsPage = SaucelabsKotlin(this.driver, 10, SAUCELABS_URL)
        saucelabsPage.open()
        saucelabsPage.waitUntilLoaded()
        saucelabsPage.login(username, password)
        Assert.assertTrue(saucelabsPage.isUserValid(),"User is invalid")
        Thread.sleep(1000)
        saucelabsPage.close()
    }

    @Test(groups = ["sanity"], dataProvider = INVALID_USER_PROVIDER)
    fun `when logging in with incorrect credentials should display popup`(username: String, password: String) {
        val saucelabsPage = SaucelabsKotlin(this.driver, 10, SAUCELABS_URL)
        saucelabsPage.open()
        saucelabsPage.waitUntilLoaded()
        saucelabsPage.login(username, password)
        Assert.assertFalse(saucelabsPage.isUserValid(), "User is valid")
        Thread.sleep(2000)
        saucelabsPage.close()
    }

    @Test(groups = ["sanity"], dataProvider = INVALID_USER_PROVIDER)
    fun `after logggin in should be able to sort items A to Z`(username: String, password: String) {
        val saucelabsPage = SaucelabsKotlin(this.driver, 10, SAUCELABS_URL)
        saucelabsPage.open()
        saucelabsPage.waitUntilLoaded()
        val productPage = saucelabsPage.loginAndGoToProducts(username, password)
        productPage.waitUntilLoaded()
//        productPage.sortAtoZ()
        Thread.sleep(2000)
        saucelabsPage.close()
    }

    companion object {
        const val SAUCELABS_URL = "https://www.saucedemo.com/"
        const val STANDARD_USER = "standard_user"
        const val PROBLEM_USER = "problem_user"
        const val PASSWORD = "secret_sauce"
        const val WRONG_PASSWORD = "secret_sauces"
        const val VALID_USER_PROVIDER = "validUserDataProvider"
        const val INVALID_USER_PROVIDER = "invalidUserDataProvider"

    }
}