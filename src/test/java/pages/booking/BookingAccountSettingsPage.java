package pages.booking;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;

public class BookingAccountSettingsPage extends BookingBasePage {

    private static final String PERSONAL_DETAILS_CSS = ".my-settings-section-card-title";

    public void getPersonalDetailsPage() {
        driver.findElement(By.cssSelector(PERSONAL_DETAILS_CSS)).click();
    }
}
