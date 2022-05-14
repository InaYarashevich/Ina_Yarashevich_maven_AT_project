package pages.booking.registration;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;
import utils.CreateMailUtils;

public class BookingRegisterEmailPage extends BookingBasePage {

    CreateMailUtils createMail = new CreateMailUtils();
    private static final String EMAIL_INPUT_CSS = "#username";
    private static final String SUBMIT_BUTTON_XPATH = "//button[@type='submit']";

    public void inputEmail(){
        driver.findElement(By.cssSelector(EMAIL_INPUT_CSS)).sendKeys(createMail.createTempMail());
    }

    public void submitEmail(){
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
    }
}
