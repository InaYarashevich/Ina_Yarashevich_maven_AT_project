package homework.day17;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HotelsRatingTest {

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
        WebElement city = driver.findElement(By.xpath("//input[@type='search']"));
        city.sendKeys("Лондон");
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
        driver.findElement(By.xpath("//span[@aria-label='" + checkInDate + " " + currentMonth + " 2022']"))
                .click();
        driver.findElement(By.xpath("//span[@aria-label='" + checkOutDate + " " + currentMonth + " 2022']"))
                .click();
        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@data-filters-group='review_score']//input[@value='review_score=90']/../label/span")).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//img/..")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement ratingElement = driver.findElement(By.xpath("//div[@data-testid='review-score-right-component']/div[@aria-label]"));
        String rating = ratingElement.getText().replaceAll("[^0-9]", "");
        long actualHotelRating = Integer.parseInt(rating);
        Assert.assertTrue("The hotel's rating is less than 9.", actualHotelRating / 10 >= 9);
    }
}