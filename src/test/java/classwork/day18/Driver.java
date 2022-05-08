package classwork.day18;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(Config config){
        if (webDriver == null){
            webDriver = DriverManager.getDriver(config);
        }
        return webDriver;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(Config.CHROME);
        }
        return webDriver;
    }
}
