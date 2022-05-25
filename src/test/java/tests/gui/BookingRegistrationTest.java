package tests.gui;

import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.gui.settingsPages.BookingAccountSettingsPage;
import pages.gui.main.BookingHomepage;
import pages.gui.main.BookingMainPage;
import pages.gui.settingsPages.BookingPersonalDetailsPage;
import pages.gui.login.BookingSignInPage;
import pages.gui.registration.BookingRegistrationPage;
import pages.gui.utils.MailRuInboxFolderPage;
import pages.gui.utils.MailRuMainPage;
import steps.gui.BaseSteps;
import utils.CreatingTempMail;

public class BookingRegistrationTest extends BaseSteps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingRegistrationPage registrationPage = new BookingRegistrationPage();
    CreatingTempMail tempMail = new CreatingTempMail();
    BookingHomepage homepage = new BookingHomepage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingPersonalDetailsPage personalDetailsPage = new BookingPersonalDetailsPage();
    BookingAccountSettingsPage accountSettingsPage = new BookingAccountSettingsPage();
    MailRuMainPage mailRuMainPage = new MailRuMainPage();
    MailRuInboxFolderPage mailRuInboxFolderPage = new MailRuInboxFolderPage();

    private static final Logger LOGGER =
            Logger.getLogger(BookingRegistrationTest.class.getName());

    @Before
    public void createEmail() {
        LOGGER.info("#Starting the test#");
        Driver.getWebDriver().manage().window().maximize();
        Driver.getWebDriver().get("https://trashmail.com/?lang=en");
        tempMail.setTempEmail(tempMail.createTempMail("ina.yarashevich@gmail.com"));
        LOGGER.info("Temporary email is created on Trashmail.");
    }

    @Test
    public void registerWithEmailPassword() {
        Driver.getWebDriver().get("https://www.booking.com/");
        LOGGER.info("Booking.com main page is opened.");
        mainPage.startRegistration();
        LOGGER.info("Registration is initiated.");
        registrationPage.register(tempMail.getTempEmail(), "Automation2022!");
        LOGGER.info("Valid email and password are submitted.");
        Assert.assertTrue("The Greeting message is displayed!", homepage.getGreeting().isDisplayed());
    }

    @Test
    public void verifyEmailIsConfirmed() {
        Driver.getWebDriver().get("https://mail.ru/");
        LOGGER.info("MAIL.RU main page is opened.");
        mailRuMainPage.loginMailRu("jane.doe2022@mail.ru", "Automation2022!");
        LOGGER.info("Logged in with valid email, password into MAIL.RU account.");
        mailRuInboxFolderPage.openEmail("One click to confirm");
        LOGGER.info("Opened email from Booking to confirm registration.");
        mailRuInboxFolderPage.confirmEmail();
        LOGGER.info("Confirm button is clicked.");
        Driver.getWebDriver().close();
        Driver.getWebDriver().get("https://www.booking.com/");
        LOGGER.info("Booking.com main page is opened.");
        mainPage.clickSignIn();
        LOGGER.info("Login is initiated.");
        signInPage.signIn(tempMail.getTempEmail(), "Automation2022!");
        LOGGER.info("Valid email and password are submitted.");
        homepage.getAccountSettingsPage();
        LOGGER.info("Homepage is opened.");
        accountSettingsPage.getPersonalDetailsPage();
        LOGGER.info("Account Settings Page is opened.");
        Assert.assertTrue("The email is not verified!", personalDetailsPage.getEmailStatus().isDisplayed());
    }
}
