package tests;

import driver.Driver;
import driver.DriverManager;
import org.junit.Assert;
import org.junit.Test;
import pages.booking.BookingAccountSettingsPage;
import pages.booking.BookingHomepage;
import pages.booking.BookingMainPage;
import pages.booking.BookingPersonalDetailsPage;
import pages.booking.login.BookingSignInPage;
import pages.booking.registration.BookingRegistrationPage;
import pages.utils.MailRuInboxFolderPage;
import pages.utils.TrashmailMainPage;
import steps.BaseSteps;
import utils.CreatingTempMail;
import utils.MailConfirmation;

public class BookingRegistrationTest extends BaseSteps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingRegistrationPage registrationPage = new BookingRegistrationPage();
    CreatingTempMail tempMail = new CreatingTempMail();
    MailConfirmation mailConfirmation = new MailConfirmation();
    BookingHomepage homepage = new BookingHomepage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();
    BookingAccountSettingsPage accountSettingsPage = new BookingAccountSettingsPage();
    TrashmailMainPage trashmailMainPage = new TrashmailMainPage();
    MailRuInboxFolderPage mailRuInboxFolderPage = new MailRuInboxFolderPage();

    @Test
    public void registerWithEmailPassword() {
        String email = tempMail.createTempMail("jane.doe2022@mail.ru");
        Driver.getWebDriver().get("https://www.booking.com/");
        mainPage.startRegistration();
        registrationPage.register(email, "Automation2022!");
        mailConfirmation.confirmRegistration(
                "jane.doe2022@mail.ru", "Automation2022!", "One more click to confirm your account");
        mainPage.clickSignIn();
        signInPage.signIn(email, "Automation2022!");
        homepage.getAccountSettingsPage();
        accountSettingsPage.getPersonalDetailsPage();
        Assert.assertTrue("The email is not verified!", personalDetailsPage.getEmailStatus().isDisplayed());
    }
}
