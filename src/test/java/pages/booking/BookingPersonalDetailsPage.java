package pages.booking;

import classwork.day19.pages.BookingBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookingPersonalDetailsPage extends BookingBasePage {

    private static final String EMAIL_ADDRESS_STATUS_XPATH = "//span[text()='Verified']";

    public WebElement getEmailStatus() {
        return driver.findElement(By.xpath(EMAIL_ADDRESS_STATUS_XPATH));
    }
}
