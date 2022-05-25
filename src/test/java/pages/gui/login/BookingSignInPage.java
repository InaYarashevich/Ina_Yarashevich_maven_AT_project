package pages.gui.login;

import org.openqa.selenium.By;
import pages.gui.base.BookingBasePage;

public class BookingSignInPage extends BookingBasePage {

    public static final String EMAIL_INPUT_CSS = "#username";
    public static final String SUBMIT_BUTTON_XPATH = "//button[@type='submit']";
    private static final String PASSWORD_CSS = "#password";
    private static final String SIGNIN_BUTTON_XPATH = "//span[text()='Sign in']";

    public void signIn(String email, String password) {
        driver.findElement(By.cssSelector(EMAIL_INPUT_CSS)).sendKeys(email);
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
        driver.findElement(By.cssSelector(PASSWORD_CSS)).sendKeys(password);
        driver.findElement(By.xpath(SIGNIN_BUTTON_XPATH)).click();
    }
}
