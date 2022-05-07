package homework.day17;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SelectTest {
    static WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        SelectTest selectTest = new SelectTest();

    }

    @Test
    public static void main(String[] args) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/select-menu");
        WebElement firstSelect = driver.findElement(By.id("withOptGroup"));
        firstSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(., 'Group 1, option 1')]"))))
                .click();

        WebElement secondSelect = driver.findElement(By.id("selectOne"));
        secondSelect.click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(., 'Ms.')]"))))
                .click();

        WebElement thirdSelect = driver.findElement(By.id("oldSelectMenu"));
        thirdSelect.click();
        Select oldStyleColorSelect = new Select(driver.findElement(By.id("oldSelectMenu")));
        oldStyleColorSelect.selectByIndex(3);

        WebElement fourthSelect = driver.findElement(By.id("//*[text()='Multiselect drop down']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", fourthSelect);
        fourthSelect.click();

        Select fifthSelect = new Select(driver.findElement(By.id("cars")));
        fifthSelect.selectByIndex(3);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
