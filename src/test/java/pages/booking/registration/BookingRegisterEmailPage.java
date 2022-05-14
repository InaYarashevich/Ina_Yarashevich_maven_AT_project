package pages.booking.registration;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;
import utils.CreateMailUtils;

import static pages.booking.login.BookingSignInEmailPage.EMAIL_INPUT_CSS;
import static pages.booking.login.BookingSignInEmailPage.SUBMIT_BUTTON_XPATH;

public class BookingRegisterEmailPage extends BookingBasePage {

    CreateMailUtils createMail = new CreateMailUtils();

    public void inputEmail(){
        driver.findElement(By.cssSelector(EMAIL_INPUT_CSS)).sendKeys(createMail.createTempMail());
    }

    public void submitEmail(){
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
    }
}
