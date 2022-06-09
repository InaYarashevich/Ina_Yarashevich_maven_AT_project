package pages.gui.utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;

public class TrashmailMainPage {

    public WebDriver driver = Driver.getWebDriver();
    private static final String REAL_EMAIL_CSS = "#fe-forward";
    private static final String NUMBER_OF_FORWARDS_DROPDOWN_CSS = "#fe-fwd-nb~div";
    private static final String SUBMIT_BUTTON_CSS = "#fe-submit";
    private static final String CREATED_EMAIL_CSS = "#fe-dea";

    public TrashmailMainPage() throws MalformedURLException {
    }

    public String getMail(String realEmail) {
        WebElement emailInput = driver.findElement(By.cssSelector(REAL_EMAIL_CSS));
        emailInput.clear();
        emailInput.sendKeys(realEmail);
        driver.findElement(By.cssSelector(NUMBER_OF_FORWARDS_DROPDOWN_CSS)).click();
        Actions select = new Actions(driver);
        select
                .sendKeys(Keys.ARROW_UP)
                .sendKeys(Keys.ARROW_UP)
                .sendKeys(Keys.ARROW_UP)
                .sendKeys(Keys.ARROW_UP)
                .sendKeys(Keys.ENTER)
                .build().perform();
        driver.findElement(By.cssSelector(SUBMIT_BUTTON_CSS)).click();
        return driver.findElement(By.cssSelector(CREATED_EMAIL_CSS)).getAttribute("value");
    }
}
