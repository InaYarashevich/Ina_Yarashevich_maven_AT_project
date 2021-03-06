package tests.gui;

import driver.Config;
import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.gui.main.BookingMainPage;
import pages.gui.searchResults.BookingSearchResultPage;

import java.net.MalformedURLException;


public class BookingMaxPriceTest {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSearchResultPage searchResultPage = new BookingSearchResultPage();

    public static final Logger LOGGER =
            Logger.getLogger(BookingMaxPriceTest.class.getName());

    public BookingMaxPriceTest() throws MalformedURLException {
    }

    @Before
    public void setup(){
        Driver.setConfig(Config.FIREFOX);
    }

    @Test
    public void getHotelsWithMaxPriceTest() throws MalformedURLException {
        Driver.getWebDriver().get("https://www.booking.com/");
        LOGGER.info("Navigating to Booking.com main page");
        mainPage.searchCity("Paris");
        LOGGER.info("The city is selected");
        mainPage.selectCheckInDate();
        mainPage.selectCheckoutDate(7);
        LOGGER.info("The dates are selected");
        mainPage.selectNumberOfVisitors(2, 0);
        mainPage.selectNumberOfRooms(1);
        LOGGER.info("The number of visitors and rooms are selected");
        mainPage.clickSearch();
        LOGGER.info("The search started");
        searchResultPage.filterResultsByPrice("max");
        LOGGER.info("The results are filtered by price");
        searchResultPage.sortByLowestPrice();
        LOGGER.info("The results are sorted by the lowest price first");

        double actualPrice = searchResultPage.getHotelPrice();
        Assert.assertTrue("The selected hotel price is less than the max price",
                actualPrice >= searchResultPage.getMaxPrice());
    }

    @After
    public void finish(){
        Driver.destroy();
    }
}
