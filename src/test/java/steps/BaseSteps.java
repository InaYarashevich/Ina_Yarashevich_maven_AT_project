package steps;

import pages.booking.BookingHomepage;
import pages.booking.BookingMainPage;
import pages.booking.BookingWishlistPage;
import pages.booking.login.BookingSignInPage;
import pages.booking.registration.BookingRegistrationPage;
import pages.booking.results.BookingFilteredResultPage;
import pages.booking.results.BookingSearchResultPage;
import pages.booking.results.BookingSortedResultPage;

public class BaseSteps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSearchResultPage resultPage = new BookingSearchResultPage();
    BookingFilteredResultPage filteredResultPage = new BookingFilteredResultPage();
    BookingSortedResultPage sortedResultPage = new BookingSortedResultPage();
    BookingHomepage homepage = new BookingHomepage();
    BookingWishlistPage wishlistPage = new BookingWishlistPage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingRegistrationPage registrationPage = new BookingRegistrationPage();
}
