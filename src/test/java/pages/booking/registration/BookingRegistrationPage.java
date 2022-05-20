package pages.booking.registration;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;

import static pages.booking.login.BookingSignInPage.EMAIL_INPUT_CSS;
import static pages.booking.login.BookingSignInPage.SUBMIT_BUTTON_XPATH;

public class BookingRegistrationPage extends BookingBasePage {

    private static final String NEW_PASSWORD_CSS = "input[name='new_password']";
    private static final String CONFIRMED_PASSWORD_CSS = "input[name='confirmed_password']";
    private static final String CREATE_ACCOUNT_BUTTON_XPATH = "//span[text()='Create account']";

    public void register(String email, String password) {
        driver.findElement(By.cssSelector(EMAIL_INPUT_CSS)).sendKeys(email);
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
        driver.findElement(By.cssSelector(NEW_PASSWORD_CSS)).sendKeys(password);
        driver.findElement(By.cssSelector(CONFIRMED_PASSWORD_CSS)).sendKeys(password);
        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON_XPATH)).click();
    }
}
