package steps.gui;


import pages.gui.login.BookingSignInPage;
import pages.gui.main.*;
import pages.gui.registration.BookingRegistrationPage;
import pages.gui.searchResults.BookingSearchResultPage;
import pages.gui.settingsPages.BookingAccountSettingsPage;
import pages.gui.settingsPages.BookingPersonalDetailsPage;
import pages.gui.utils.MailRuInboxFolderPage;
import pages.gui.utils.MailRuMainPage;
import utils.CreatingTempMail;

public class BaseSteps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSearchResultPage searchResultPage = new BookingSearchResultPage();
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
