package pages.gui.settingsPages;

import org.openqa.selenium.By;
import pages.gui.base.BookingBasePage;

import java.net.MalformedURLException;

public class BookingAccountSettingsPage extends BookingBasePage {

    private static final String PERSONAL_DETAILS_CSS = ".my-settings-section-card-title";

    public BookingAccountSettingsPage() throws MalformedURLException {
    }

    public void getPersonalDetailsPage() {
        driver.findElement(By.cssSelector(PERSONAL_DETAILS_CSS)).click();
    }
}
