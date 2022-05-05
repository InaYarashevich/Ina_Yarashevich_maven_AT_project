package homework.day17;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WSchoolsTest {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/java/");
        WebElement spanTutorial = driver.findElement(By.xpath("//h1/span[text()='Tutorial']"));
        Actions make = new Actions(driver);
        make
                .doubleClick(spanTutorial)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
        driver.get("https://google.com");
        driver.findElement(By.name("q"));
        Actions insert = new Actions(driver);
        insert
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        List<WebElement> searchResult = driver.findElements(By.xpath("//div[contains(.,'tutorial') and contains(@class, 'g')]"));
        Assert.assertEquals("The number of results is less than 12", 12, searchResult.size());
        driver.quit();
    }
}
