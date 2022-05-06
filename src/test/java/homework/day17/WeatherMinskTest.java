package homework.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class WeatherMinskTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        String tomorrow = LocalDate.now(ZoneId.systemDefault()).plusDays(1)
                .getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("be"));
        int currentTime = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("погода Минск");
        WebElement elementSearch = driver.findElement(By.xpath("//input[@title='Шукаць']"));
        elementSearch.sendKeys(Keys.ARROW_DOWN);
        elementSearch.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(String.format("//div[@aria-label='%s']/..", tomorrow)))
                .click();

        if (currentTime > 12) {
            System.out.println(driver
                    .findElement(By.xpath("//*[contains(normalize-space(@aria-label), '12:00') and contains(@aria-label,'Celsius')][1]"))
                    .getAttribute("aria-label"));
        } else {
            System.out.println(driver
                    .findElement(By.xpath("//*[contains(normalize-space(@aria-label), '12:00') and contains(@aria-label,'Celsius')][2]"))
                    .getAttribute("aria-label"));
        }
        driver.quit();
    }
}
