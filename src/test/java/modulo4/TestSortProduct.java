package modulo4;

import common.BaseTestMultiThread;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saucelab.pages.Login;
import saucelab.pages.Producto;

public class TestSortProduct extends BaseTestMultiThread {
    private static final String URL = "https://www.saucedemo.com/";

    private static final int TIME_OUT = 10;

    @DataProvider(name = "sortDataProvider")
    public Object[][] sortDataProvider() {
        return new Object [][] {
              {"standard_user", "secret_sauce", Producto.SortOption.HILO},
                {"standard_user", "secret_sauce", Producto.SortOption.AZ},
               {"standard_user", "secret_sauce", Producto.SortOption.ZA},
                {"standard_user", "secret_sauce", Producto.SortOption.LOHI},
        };
    }

    @Test(dataProvider = "sortDataProvider", groups = {"product"})
    public void testSortProducts(String user, String password, Producto.SortOption option) {
        Login loginPage = new Login(this.getDriver(), TIME_OUT, URL);
        loginPage.open();
        loginPage.waitUntilLoaded();
        Producto productPage = loginPage.login(user, password);
        Assert.assertTrue(loginPage.isValidUser());
        productPage.waitUntilLoaded();
        productPage.sort(option);

        //validar si la lista esta ordenada
        Assert.assertTrue(productPage.isSorted(option));
    }


}

