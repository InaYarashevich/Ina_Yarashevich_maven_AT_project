package pages.utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class MailRuMainPage {

    public WebDriver driver = Driver.getWebDriver();
    private static final String MAILRU_SIGNIN_XPATH = "//button[contains(text(),'Войти')]";
    private static final String MAIL_BUTTON_XPATH = "//a[@data-testid='logged-out-email']";
    private static final String ACCOUNT_NAME_XPATH = "//input[@name='username']";
    private static final String ENTER_PASSWORD_CSS = "button[data-test-id='next-button']";
    private static final String PASSWORD_CSS = "input[name='password']";
    private static final String SIGNIN_CSS = "button[data-test-id='submit-button']";

    public void loginMailRu(String accountName, String password) {
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath(MAIL_BUTTON_XPATH)).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath(ACCOUNT_NAME_XPATH)).sendKeys(accountName);
        driver.findElement(By.cssSelector(ENTER_PASSWORD_CSS)).click();
        driver.findElement(By.cssSelector(PASSWORD_CSS)).sendKeys(password);
        driver.findElement(By.cssSelector(SIGNIN_CSS)).click();
    }
}
