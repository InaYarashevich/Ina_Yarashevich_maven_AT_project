package homework.day17;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TooltipOnHoverTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.booking.com/");
        WebElement currency = driver.findElement(By.xpath("//button[@data-tooltip-text='Choose your currency']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(currency);
        actions.perform();
        String tooltipCurrency = currency.getAttribute("data-tooltip-text");
        Assert.assertEquals("The currency tooltip text is incorrect!", "Choose your currency", tooltipCurrency);

        WebElement language = driver.findElement(By.xpath("//button[@data-tooltip-text='Choose your currency']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(language);
        actions1.perform();
        String tooltipLanguage = currency.getAttribute("data-tooltip-text");
        Assert.assertEquals("The language tooltip text is incorrect!", "Choose your language", tooltipLanguage);
    }
}
