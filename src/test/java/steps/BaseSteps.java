package steps;

import io.cucumber.java.it.Ma;
import pages.booking.*;
import pages.booking.login.BookingSignInPage;
import pages.booking.registration.BookingRegistrationPage;
import pages.booking.results.BookingFilteredResultPage;
import pages.booking.results.BookingSearchResultPage;
import pages.booking.results.BookingSortedResultPage;
import pages.utils.MailRuInboxFolderPage;
import pages.utils.MailRuMainPage;
import utils.CreatingTempMail;

public class BaseSteps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSearchResultPage resultPage = new BookingSearchResultPage();
    BookingFilteredResultPage filteredResultPage = new BookingFilteredResultPage();
    BookingSortedResultPage sortedResultPage = new BookingSortedResultPage();
    BookingHomepage homepage = new BookingHomepage();
    BookingWishlistPage wishlistPage = new BookingWishlistPage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingRegistrationPage registrationPage = new BookingRegistrationPage();
    MailRuInboxFolderPage mailRuInboxFolderPage = new MailRuInboxFolderPage();
    BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();
    CreatingTempMail creatingTempMail = new CreatingTempMail();
    BookingAccountSettingsPage accountSettingsPage = new BookingAccountSettingsPage();
    MailRuMainPage mailRuMainPage = new MailRuMainPage();
}
