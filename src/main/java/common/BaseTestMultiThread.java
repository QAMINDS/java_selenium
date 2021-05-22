package common;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BaseTestMultiThread {
    private final static Map<String, WebDriver> DRIVERS = new HashMap<>();
    protected String user;
    protected String password;
    protected WebDriverFactory.BrowserName browser;

    @BeforeClass
    @Parameters({"user", "password",  "browser", })
    public void beforeClass(String user, String password, String browser) {
        this.user = user;
        this.password = password;
        this.browser = WebDriverFactory.BrowserName.valueOf(browser.toUpperCase());
    }

    @BeforeMethod
    public void beforeMethod(Method method, ITestResult testResult) {
        WebDriver driver = WebDriverFactory.getDriver(this.browser);
        DRIVERS.put(method.getName(), driver);
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult testResult) {
        WebDriver driver = DRIVERS.getOrDefault(method.getName(), null);
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        Method caller = this.getCallerMethod();
        return DRIVERS.getOrDefault(caller.getName(), null);
    }

    public void setDriver(WebDriver driver) {
        Method caller = this.getCallerMethod();
        DRIVERS.put(caller.getName(), driver);
    }

    private synchronized Method getCallerMethod() {
        try {
            for (StackTraceElement stElement: Thread.currentThread().getStackTrace()) {
                String methodName = stElement.getMethodName();
                Class<?> kls = Class.forName(stElement.getClassName());
                for (Method method : kls.getMethods()) {
                    if (method.getName().equals(methodName) && method.getAnnotation(Test.class) != null) {
                        return method;
                    }
                }
            }
            throw new RuntimeException("Get reporter was called outside a test method: %s");
        } catch(Exception exception) {
            throw new RuntimeException(String.format("Get reporter was called outside a test method: %s", exception));
        }
    }

}
