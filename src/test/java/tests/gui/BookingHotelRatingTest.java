package tests.gui;

import driver.Config;
import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ElementNotInteractableException;
import pages.gui.main.BookingMainPage;
import pages.gui.base.BookingBasePage;
import pages.gui.searchResults.BookingSearchResultPage;

import java.util.ArrayList;

public class BookingHotelRatingTest extends BookingBasePage {
    BookingMainPage mainPage = new BookingMainPage();
    BookingSearchResultPage searchResultPage = new BookingSearchResultPage();
    private static final Logger LOGGER =
            Logger.getLogger(BookingHotelRatingTest.class.getName());

    @Before
    public void startTest() {
        LOGGER.info("#Starting the test#");
        Driver.getWebDriver().manage().window().maximize();
    }

    @Test
    public void bookingHotelRatingTest() {
        Driver.getWebDriver().get("https://www.booking.com/");
        LOGGER.info("Booking.com main page is opened.");
        mainPage.searchCity("Madrid");
        LOGGER.info("The destination city is selected.");
        mainPage.clickSearch();
        LOGGER.info("Start searching hotels.");

        try {
            searchResultPage.filterResultsByRating("SUPERB");
            LOGGER.info("Filtering hotels by max rating.");
        } catch (ElementNotInteractableException exception){
            searchResultPage.closeCalendar();
        }

        searchResultPage.openHotelDetailsPage(0);
        LOGGER.info("Opening hotel details page.");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        try {
            driver.switchTo().window(tabs.get(1));
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            searchResultPage.openHotelDetailsPage(0);
        }
        driver.switchTo().window(tabs.get(1));

        Assert.assertTrue("The actual hotel rating is less than the expected max hotel rating.",
                searchResultPage.getHotelRating() >= searchResultPage.getHotelRating());
    }

    @After
    public void afterTest() {
        Driver.destroy();
        LOGGER.info("Test finished.");
    }
}
