package driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    private static Config config;

    public static void setConfig(Config theConfig) {
        config = theConfig;
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = DriverManager.getDriver(Config.CHROME);
        }
        setTimeouts(30);
        return driver;
    }

    public static void setTimeouts(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
    }

    public static void destroy() {
        driver.quit();
        driver = null;
    }
}
