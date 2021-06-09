package common;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseTestMultiThread {
    private Map<String, WebDriver> drivers;
    protected String user;
    protected String password;
    protected WebDriverFactory.BrowserName browser;

    @BeforeClass
    //@Parameters({"user", "password",  "browser", })
    public synchronized void beforeClass() {
        this.user = user;
        this.password = password;
        this.browser = WebDriverFactory.BrowserName.CHROME;
        this.drivers = new ConcurrentHashMap<>();
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method, ITestResult testResult) {
        WebDriver driver = WebDriverFactory.getDriver(this.browser);
        this.drivers.put(method.getName(), driver);
    }

    @AfterMethod
    public synchronized void afterMethod(Method method, ITestResult testResult) {
        WebDriver driver = this.drivers.getOrDefault(method.getName(), null);
        if (driver != null) {
            this.drivers.remove(method.getName());
            driver.quit();
        }
    }

    public synchronized WebDriver getDriver() {
        Method caller = this.getCallerTestMethod();
        return this.drivers.getOrDefault(caller.getName(), null);
    }

    private synchronized Method getCallerTestMethod() {
        try {
            for (StackTraceElement stackElement: Thread.currentThread().getStackTrace()) {
                String mName = stackElement.getMethodName();
                Class cKls = Class.forName(stackElement.getClassName());
                Method[] mts = cKls.getMethods();
                Method method = Arrays.stream(mts).filter(m -> mName.equals(m.getName())).findFirst().orElse(null);
                if (method != null && method.getAnnotation(Test.class) != null) {
                    return method;
                }
            }
            throw new RuntimeException("Get caller was executed outside a test method: %s");
        } catch(Exception exception) {
            throw new RuntimeException(String.format("Get caller was executed outside a test method: %s", exception));
        }
    }

}
