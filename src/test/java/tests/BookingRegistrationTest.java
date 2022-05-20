package tests;

import driver.Driver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.booking.BookingAccountSettingsPage;
import pages.booking.BookingHomepage;
import pages.booking.BookingMainPage;
import pages.booking.BookingPersonalDetailsPage;
import pages.booking.login.BookingSignInPage;
import pages.booking.registration.BookingRegistrationPage;
import pages.utils.MailRuInboxFolderPage;
import pages.utils.MailRuMainPage;
import pages.utils.TrashmailMainPage;
import steps.BaseSteps;
import utils.CreatingTempMail;

public class BookingRegistrationTest extends BaseSteps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingRegistrationPage registrationPage = new BookingRegistrationPage();
    CreatingTempMail tempMail = new CreatingTempMail();
    BookingHomepage homepage = new BookingHomepage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();
    BookingAccountSettingsPage accountSettingsPage = new BookingAccountSettingsPage();
    TrashmailMainPage trashmailMainPage = new TrashmailMainPage();
    MailRuMainPage mailRuMainPage = new MailRuMainPage();
    MailRuInboxFolderPage mailRuInboxFolderPage = new MailRuInboxFolderPage();

    @Before
    public String createEmail() {
        return tempMail.createTempMail("jane.doe2022@mail.ru");
    }

    @Test
    public void registerWithEmailPassword() {
        Driver.getWebDriver().get("https://www.booking.com/");
        mainPage.startRegistration();
        registrationPage.register(createEmail(), "Automation2022!");
        Driver.getWebDriver().get("https://mail.ru/");
        mailRuMainPage.loginMailRu("jane.doe2022@mail.ru", "Automation2022!");
        mailRuInboxFolderPage.openEmail("One more click to confirm your account");
        mailRuInboxFolderPage.confirmEmail();
        Driver.getWebDriver().get("https://www.booking.com/");
        mainPage.clickSignIn();
        signInPage.signIn(createEmail(), "Automation2022!");
        homepage.getAccountSettingsPage();
        accountSettingsPage.getPersonalDetailsPage();
        Assert.assertTrue("The email is not verified!", personalDetailsPage.getEmailStatus().isDisplayed());
    }
}