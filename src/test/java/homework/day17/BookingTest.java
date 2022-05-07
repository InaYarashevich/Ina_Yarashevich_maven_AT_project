package homework.day17;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        String currentMonth = new SimpleDateFormat("MMMM").format(new Date());
        int checkInDate = currentDay + 3;
        int checkOutDate = checkInDate + 7;

        driver.get("https://www.booking.com/");
        WebElement findParis = driver.findElement(By.xpath("//input[@type='search']"));
        findParis.sendKeys("Париж");
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

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@name='pri=5']/following-sibling::label/span")).click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[contains(text(),'Top picks ')]")).click();
        driver.findElement(By.xpath("//*[text()='Price (lowest first)']")).click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement hotelPriceElement = driver.findElement(
                By.xpath(
                        "//div[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='price-and-discounted-price']/span"));

        String hotelPrice = hotelPriceElement.getText().replaceAll("[^0-9]", "");
        int actualHotelPricePerNight = Integer.parseInt(hotelPrice) / 7;
        WebElement maxPricePerNightElement = driver.findElement(By.xpath("//div[@data-filters-item='pri:pri=5']//div[@data-testid='filters-group-label-content']"));
        String maxPricePerNight = maxPricePerNightElement.getText().replaceAll("[^0-9]", "");
        int expectedMaxPricePerNight = Integer.parseInt(maxPricePerNight);

        Assert.assertTrue("The actual hotel price is less than the expected max price.", actualHotelPricePerNight
                >= expectedMaxPricePerNight);
        driver.quit();
    }
}
