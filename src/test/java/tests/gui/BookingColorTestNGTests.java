package tests.gui;

import driver.Config;
import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.gui.main.BookingMainPage;
import pages.gui.searchResults.BookingSearchResultPage;

public class BookingColorTestNGTests {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSearchResultPage searchResultPage = new BookingSearchResultPage();

    public static final Logger LOGGER =
            Logger.getLogger(BookingMaxPriceTest.class.getName());

    @BeforeClass
    public static void initDriver() {
        Driver.setConfig(Config.CHROME);
    }

    @Test
    public void changeHotelTitleColorTest()  {
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
        LOGGER.info("Started searching");
        searchResultPage.paintHotelTitleColor(10);
        LOGGER.info("The title color is changed");
        Assert.assertEquals("The title is not red!",
                "#ff0000", searchResultPage.getTitleColor());
    }

    @Test
    public void changeBackgroundColorTest()  {
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
        LOGGER.info("Started searching");
        searchResultPage.paintHotelTitleColor(10);
        LOGGER.info("The title color is changed");
        Assert.assertEquals("The title is not red!",
                "#ff0000", searchResultPage.getTitleColor());
    }

    @AfterTest
    public void closeDriver(){
        Driver.destroy();
    }
}
