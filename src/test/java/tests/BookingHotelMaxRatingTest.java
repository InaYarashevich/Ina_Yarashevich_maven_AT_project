package tests;

import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.booking.BookingMainPage;
import pages.booking.base.BookingBasePage;
import pages.booking.results.BookingSearchResultPage;

import java.util.ArrayList;

public class BookingHotelMaxRatingTest extends BookingBasePage {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSearchResultPage searchResultPage = new BookingSearchResultPage();

    private static final Logger LOGGER =
            Logger.getLogger(BookingHotelMaxRatingTest.class.getName());
    private int superbHotelRating = 90;

    @Before
    public void startTest() {
        LOGGER.info("#Starting the test#");
        Driver.getWebDriver().manage().window().maximize();
    }

    @Test
    public void bookingHotelMaxRatingTest() {
        Driver.getWebDriver().get("https://www.booking.com/");
        LOGGER.info("Booking.com main page is opened.");
        mainPage.searchCity("Madrid");
        LOGGER.info("The destination city is selected.");
        mainPage.clickSearch();
        LOGGER.info("Start searching hotels.");
        searchResultPage.filterResultsByMaxRating();
        LOGGER.info("Filtering hotels by max rating.");
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
                searchResultPage.getHotelRating() >= superbHotelRating);
    }

    @After
    public void afterTest() {
        Driver.destroy();
        LOGGER.info("Test finished.");
    }
}
