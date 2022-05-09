package classwork.day19.pages;

import classwork.day18.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingBasePage {

    private static final String LOADER_XPATH = "//div[@data-testid='overlay-spinner']";
    public WebDriver driver = Driver.getWebDriver();

    public void waitsForLoader() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADER_XPATH)));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}