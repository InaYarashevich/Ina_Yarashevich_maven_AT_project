package tests.gui;

import driver.Config;
import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.gui.main.BookingHomepage;
import pages.gui.main.BookingMainPage;
import pages.gui.main.BookingWishlistPage;
import pages.gui.base.BookingBasePage;
import pages.gui.login.BookingSignInPage;
import pages.gui.searchResults.BookingSearchResultPage;

public class BookingWishlistTest extends BookingBasePage {
    BookingMainPage mainPage = new BookingMainPage();
    BookingHomepage homepage = new BookingHomepage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingSearchResultPage searchResultPage = new BookingSearchResultPage(90);
    BookingWishlistPage wishlistPage = new BookingWishlistPage();
    private static final Logger LOGGER =
            Logger.getLogger(BookingWishlistTest.class.getName());

    @Before
    public void startTest(){
        LOGGER.info("#Starting the test#");
        Driver.setConfig(Config.CHROME);
    }

    @Test
    public void getWishlistItemsTest() {
        driver.get("https://www.booking.com/");
        LOGGER.info("Switching to Sign in page");
        mainPage.clickSignIn();
        LOGGER.info("Switching to Sign in page");
        signInPage.signIn("oreilly.kennedy@trashmail.fr", "Automation2022!");
        LOGGER.info("Logged in to account with valid email and password");
        homepage.searchCity("Madrid");
        LOGGER.info("The destination city is selected");
        homepage.setCheckInDate();
        LOGGER.info("Check in date is selected");
        homepage.setCheckoutDate();
        LOGGER.info("Check out date is selected");
        homepage.clickSearch();
        LOGGER.info("Start searching hotels");
        searchResultPage.addToWishlist(0);
        LOGGER.info("Saving the first hotel to wishlist");
        searchResultPage.addToWishlist(24);
        LOGGER.info("Saving last from the list hotel to wishlist");
        searchResultPage.navigateToWishlist();
        LOGGER.info("Navigating to wishlist");
        Assert.assertTrue("The title of the hotel saved in wishlist is different!",
                wishlistPage.getSavedHotelTitle(0).equalsIgnoreCase(searchResultPage.getHotelTitle(0)));
    }
    @After
    public void endTest(){
        LOGGER.info("The test is finished.");
    }
}
