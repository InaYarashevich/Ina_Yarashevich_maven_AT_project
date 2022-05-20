package pages.booking;

import classwork.day19.pages.BookingBasePage;
import org.openqa.selenium.By;

public class BookingAccountSettingsPage extends BookingBasePage {

    private static final String PERSONAL_DETAILS_CSS = ".my-settings-section-card-title";

    public void getPersonalDetailsPage() {
        driver.findElement(By.cssSelector(PERSONAL_DETAILS_CSS)).click();
    }
}
