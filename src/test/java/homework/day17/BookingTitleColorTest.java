package homework.day17;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookingTitleColorTest {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LocalDate currentLocalDate = LocalDate.now();
        int currentDay = currentLocalDate.getDayOfMonth();
        String currentMonth = new SimpleDateFormat("MMMM").format(new Date());
        int checkInDate = currentDay + 3;
        int checkOutDate = checkInDate + 7;

        driver.get("https://www.booking.com/");
        WebElement city = driver.findElement(By.xpath("//input[@type='search']"));
        city.sendKeys("Париж");
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
        driver.findElement(By.xpath(String.format("//span[@aria-label='%s %s 2022']", checkInDate, currentMonth)))
                .click();
        driver.findElement(By.xpath(String.format("//span[@aria-label='%s %s 2022']", checkOutDate, currentMonth)))
                .click();
        driver.findElement(By.xpath("//span[contains(text(),'2 adults')]"))
                .click();
        WebElement numberOfAdults = driver.findElement(By
                .xpath("//span[text()='+']/parent::*[@aria-label='Increase number of Adults']"));
        numberOfAdults.click();
        numberOfAdults.click();
        driver.findElement(By.xpath("//span[text()='+']/parent::button[@aria-label='Increase number of Rooms']"))
                .click();
        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        WebElement hotel = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));
        WebElement title = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]//h3//div[@data-testid='title']"));
        String color = title.getCssValue("color");

        String actualColor = Color.fromString(color).asHex();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", hotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", hotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", title);
        Assert.assertEquals("The title is not red!", "#0071c2", actualColor);
        driver.quit();
    }
}
