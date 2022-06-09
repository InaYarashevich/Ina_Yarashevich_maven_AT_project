package pages.gui.settingsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.gui.base.BookingBasePage;

import java.net.MalformedURLException;

public class BookingPersonalDetailsPage extends BookingBasePage {

    private static final String EMAIL_ADDRESS_STATUS_XPATH = "//span[text()='Verified']";

    public BookingPersonalDetailsPage() throws MalformedURLException {
    }

    public WebElement getEmailStatus() {
        return driver.findElement(By.xpath(EMAIL_ADDRESS_STATUS_XPATH));
    }
}
