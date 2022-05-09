package homework.day17;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectTest {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/select-menu");

        WebElement firstSelect = driver.findElement(By.id("withOptGroup"));
        firstSelect.click();
        Actions selectOption = new Actions(driver);
        selectOption
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build().perform();

        WebElement secondSelect = driver.findElement(By.id("selectOne"));
        secondSelect.click();
        Actions selectOption2 = new Actions(driver);
        selectOption2
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build().perform();

        WebElement thirdSelect = driver.findElement(By.id("oldSelectMenu"));
        thirdSelect.click();
        Select oldStyleColorSelect = new Select(driver.findElement(By.id("oldSelectMenu")));
        oldStyleColorSelect.selectByIndex(3);

        WebElement fourthSelect = driver.findElement(By.xpath("//*[text()='Multiselect drop down']/../following-sibling::div"));
        fourthSelect.click();
        Actions selectOption4 = new Actions(driver);
        selectOption4
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build().perform();

        Select fifthSelect = new Select(driver.findElement(By.id("cars")));
        fifthSelect.selectByIndex(3);

        driver.quit();
    }
}
