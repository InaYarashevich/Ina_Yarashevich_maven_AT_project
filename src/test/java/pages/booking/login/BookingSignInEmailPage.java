package pages.booking.login;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;
import utils.CreateMailUtils;

public class BookingSignInEmailPage extends BookingBasePage {

    private static final String EMAIL_INPUT = "#username";
    private static final String SUBMIT_BUTTON_XPATH = "//button[@type='submit']";
    CreateMailUtils createMail = new CreateMailUtils();

    public void inputEmail() {
        driver.findElement(By.cssSelector(EMAIL_INPUT)).sendKeys("renee.brakus@trashmail.fr");
    }

    public void submitEmail() {
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
    }
}
