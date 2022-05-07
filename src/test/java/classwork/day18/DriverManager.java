package classwork.day18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver getDriver(Config config) {
        return switch (config) {
            case CHROME -> getChromeDriver();
            case FIREFOX -> getFirefoxDriver();
            case EDGE -> getEdgeDriver();
            default -> throw null;
        };
    }

    private static WebDriver getChromeDriver(){
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver(){
        return new FirefoxDriver();
    }

    private static WebDriver getEdgeDriver(){
        return new EdgeDriver();
    }
}