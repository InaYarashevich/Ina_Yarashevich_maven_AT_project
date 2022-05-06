package homework.day17;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        WebElement selectOne = driver.findElement(By.id("selectOne"));
        selectOne.click();

        WebElement oldSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        oldSelectMenu.click();
        Select oldStyleColorSelect = new Select(driver.findElement(By.id("oldSelectMenu")));
        oldStyleColorSelect.selectByIndex(3);

        Select carsSelect = new Select(driver.findElement(By.id("cars")));
        carsSelect.selectByIndex(3);

    }

    @After
    public void teardown(){
        driver.quit();
    }
}
