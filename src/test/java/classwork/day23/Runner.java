package classwork.day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Runner {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "My");
        caps.setCapability("platformName", "android");
        caps.setCapability("browserName", "chrome");

        WebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        driver.get("https://mail.ru");
        driver.findElement(By.xpath("//a[@data-testid='news-tabs-tab-item-lady']"));
        Thread.sleep(5000);
        driver.quit();
    }
}
