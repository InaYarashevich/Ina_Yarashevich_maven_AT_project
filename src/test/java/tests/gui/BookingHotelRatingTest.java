package tests.gui;

import driver.Config;
import driver.Driver;
import objects.gui.SearchResults;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import pages.gui.main.BookingMainPage;
import pages.gui.searchResults.BookingSearchResultPage;

import java.util.ArrayList;

public class BookingHotelRatingTest {
    BookingMainPage mainPage = new BookingMainPage();

    BookingSearchResultPage searchResultPage = new BookingSearchResultPage();

    SearchResults searchResults = new SearchResults();
    private static WebDriver driver;

    private static final Logger LOGGER =
            Logger.getLogger(BookingHotelRatingTest.class.getName());

    @BeforeClass
    public static void initDriver() {
        LOGGER.info("#Starting the test#");
        Driver.setConfig(Config.FIREFOX);
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
                searchResultPage.getHotelRating() >= searchResults.getRatingFilterValue());
    }

    @After
    public void afterTest() {
        Driver.destroy();
        LOGGER.info("Test finished.");
    }
}
