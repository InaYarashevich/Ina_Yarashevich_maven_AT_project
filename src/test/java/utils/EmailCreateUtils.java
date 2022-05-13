package utils;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class EmailCreateUtils {

    public WebDriver driver = Driver.getWebDriver();
    private static final String REAL_EMAIL_CSS = "#fe-forward";
    private static String email = "ina.yarashevich@gmail.com";
    private static final String NUMBER_OF_FORWARDS_DROPDOWN_CSS = "#fe-fwd-nb~div";
    private static final String NUMBER_OF_FORWARDS_SELECT_XPATH = "//select[contains(@ng-options, 'forward.id')]";
    private static final String GET_OPTION_CSS = "*[value='number:10']";

    public void createTrashmail() {

        driver.get("https://trashmail.com/?lang=en");
        WebElement emailInput = driver.findElement(By.cssSelector(REAL_EMAIL_CSS));
        emailInput.clear();
        emailInput.sendKeys(email);
        driver.findElement(By.cssSelector(NUMBER_OF_FORWARDS_DROPDOWN_CSS)).click();
        Select select = new Select(driver.findElement(By.xpath(NUMBER_OF_FORWARDS_SELECT_XPATH)));
        select.selectByValue("number:10");
    }
}
