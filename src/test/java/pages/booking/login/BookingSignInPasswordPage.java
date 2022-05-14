package pages.booking.login;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;

public class BookingSignInPasswordPage extends BookingBasePage {

    private static final String PASSWORD_CSS = "#password";
    private static final String SIGNIN_BUTTON_XPATH = "//span[text()='Sign in']";

    public void inputPassword(){
        driver.findElement(By.cssSelector(PASSWORD_CSS)).sendKeys("Automation2022!");
    }

    public void signIn(){
        driver.findElement(By.xpath(SIGNIN_BUTTON_XPATH)).click();
    }
}
