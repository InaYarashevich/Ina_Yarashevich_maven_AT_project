package utils;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CreateMailUtils {

    public WebDriver driver = Driver.getWebDriver();
    private static final String REAL_EMAIL_CSS = "#fe-forward";
    private static String email = "igyarashevich@gmail.com";
    private static final String NUMBER_OF_FORWARDS_DROPDOWN_CSS = "#fe-fwd-nb~div";
    private static final String SUBMIT_BUTTON_CSS = "#fe-submit";

    public String createTempMail() {

        driver.get("https://trashmail.com/?lang=en");
        WebElement emailInput = driver.findElement(By.cssSelector(REAL_EMAIL_CSS));
        emailInput.clear();
        emailInput.sendKeys(email);
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

        return driver.findElement(By.cssSelector("#fe-dea")).getAttribute("value");
    }
}
