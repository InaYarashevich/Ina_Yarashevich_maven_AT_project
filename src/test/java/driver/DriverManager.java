package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverManager {

    public static WebDriver getDriver(Config config) {
        return switch (config) {
            case CHROME -> getChromeDriver();
            case FIREFOX -> getFirefoxDriver();
            case EDGE -> getEdgeDriver();
            default -> throw null;
        };
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        return new ChromeDriver(caps);
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        return new FirefoxDriver(options);
    }

    private static WebDriver getEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "D:/webdrivers/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.setCapability("start-maximized", true);
        return new EdgeDriver(options);
    }
}