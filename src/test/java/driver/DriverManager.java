package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public static WebDriver getDriver(Config config)  {
        return switch (config) {
            case CHROME -> getChromeDriver();
            case FIREFOX -> getFirefoxDriver();
            case EDGE -> getEdgeDriver();
            case REMOTE -> getChromeDriver();
        };
    }
    private static WebDriver getRemoteDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }
    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        return new ChromeDriver(caps);
    }
    private static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }
    private static WebDriver getEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "D:/webdrivers/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.setCapability("start-maximized", true);
        return new EdgeDriver(options);
    }
}