package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.BookingHomepage;
import pages.booking.BookingMainPage;
import pages.booking.BookingWishlistPage;
import pages.booking.base.BookingBasePage;
import pages.booking.login.BookingSignInPage;
import pages.booking.results.BookingSearchResultPage;

public class BookingWishlistTest extends BookingBasePage {

    BookingMainPage mainPage = new BookingMainPage();
    BookingHomepage homepage = new BookingHomepage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingSearchResultPage searchResultPage = new BookingSearchResultPage();
    BookingWishlistPage wishlistPage = new BookingWishlistPage();

    @Test
    public void getWishlistItemsTest() {

        driver.get("https://www.booking.com/");
        mainPage.clickSignIn();
        signInPage.signIn("oreilly.kennedy@trashmail.fr", "Automation2022!");
        //homepage.closeWelcomePopup();
        homepage.searchCity("Madrid");
        mainPage.selectCheckInDate();
        mainPage.selectCheckoutDate();
        mainPage.search();
        searchResultPage.addToWishlist(0);
        searchResultPage.addToWishlist(24);
        searchResultPage.navigateToWishlist();
        Assert.assertTrue("The title of the hotel saved in wishlist is different!",
                wishlistPage.getSavedHotelTitle(0).equalsIgnoreCase(searchResultPage.getHotelTitle(0)));
    }
}
