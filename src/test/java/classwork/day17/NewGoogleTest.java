package classwork.day17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewGoogleTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        driver.get("https://google.com");
        driver.navigate().to("https://ya.ru");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.quit();
    }
}
