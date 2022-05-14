package pages.booking.registration;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;

public class BookingRegisterPasswordPage extends BookingBasePage {

    private static final String NEW_PASSWORD_CSS = "input[name='new_password']";
    private static final String CONFIRMED_PASSWORD_CSS = "input[name='confirmed_password']";
    private static final String CREATE_ACCOUNT_BUTTON_XPATH = "//span[text()='Create account']";

    public void createAccount(){
        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON_XPATH)).click();
    }

    public void inputPassword(){
        driver.findElement(By.xpath(NEW_PASSWORD_CSS)).sendKeys("Automation2022!");
    }

    public void confirmPassword(){
        driver.findElement(By.cssSelector(CONFIRMED_PASSWORD_CSS)).sendKeys("Automation2022!");
    }
}
