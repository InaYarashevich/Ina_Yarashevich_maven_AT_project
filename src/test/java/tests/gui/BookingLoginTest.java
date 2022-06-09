package tests.gui;

import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.gui.main.BookingHomepage;
import pages.gui.main.BookingMainPage;
import pages.gui.login.BookingSignInPage;
import pages.gui.registration.BookingRegistrationPage;
import pages.gui.utils.MailRuInboxFolderPage;
import pages.gui.utils.MailRuMainPage;
import utils.CreatingTempMail;

import java.net.MalformedURLException;


public class BookingLoginTest {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingHomepage homepage = new BookingHomepage();
    CreatingTempMail tempMail = new CreatingTempMail();
    BookingRegistrationPage registrationPage = new BookingRegistrationPage();
    MailRuMainPage mailRuMainPage = new MailRuMainPage();
    MailRuInboxFolderPage mailRuInboxFolderPage = new MailRuInboxFolderPage();


    private static final Logger LOGGER =
            Logger.getLogger(BookingLoginTest.class.getName());

    public BookingLoginTest() throws MalformedURLException {
    }

    @Before
    public void startTest() throws MalformedURLException {
        LOGGER.info("#Starting the test#");
        Driver.getWebDriver().manage().window().maximize();
        Driver.getWebDriver().get("https://trashmail.com/?lang=en");
        tempMail.setTempEmail(tempMail.createTempMail("ina.yarashevich@gmail.com"));
        LOGGER.info("Temporary email is created on Trashmail.");
        Driver.getWebDriver().get("https://www.booking.com/");
        LOGGER.info("Booking.com main page is opened.");
        mainPage.startRegistration();
        LOGGER.info("Registration is initiated.");
        registrationPage.register(tempMail.getTempEmail(), "Automation2022!");
        LOGGER.info("Valid email and password are submitted.");
        Driver.getWebDriver().get("https://mail.ru/");
        LOGGER.info("MAIL.RU main page is opened.");
        mailRuMainPage.loginMailRu("jane.doe2022@mail.ru", "Automation2022!");
        LOGGER.info("Logged in with valid email, password into MAIL.RU account.");
        mailRuInboxFolderPage.openEmail("One click to confirm");
        LOGGER.info("Opened email from Booking to confirm registration.");
        mailRuInboxFolderPage.confirmEmail();
        LOGGER.info("Confirm button is clicked.");
        Driver.getWebDriver().close();
    }

    @Test
    public void bookingLoginWithEmailPassword() throws MalformedURLException {
        Driver.getWebDriver().get("https://www.booking.com/");
        mainPage.clickSignIn();
        signInPage.signIn(tempMail.getTempEmail(), "Automation2022!");
        Assert.assertTrue("PROFILE_MENU element is not displayed on the page!",
                homepage.getWebElement("PROFILE_MENU").isDisplayed());
        Assert.assertTrue("BOOKING_LOGO element is not displayed on the page!",
                homepage.getWebElement("BOOKING_LOGO").isDisplayed());
        Assert.assertTrue("CURRENCY element is not displayed on the page!",
                homepage.getWebElement("CURRENCY").isDisplayed());
        Assert.assertTrue("LANGUAGE element is not displayed on the page!",
                homepage.getWebElement("LANGUAGE").isDisplayed());
        Assert.assertTrue("YOUR_PROPERTY_ICON element is not displayed on the page!",
                homepage.getWebElement("YOUR_PROPERTY_ICON").isDisplayed());
        Assert.assertTrue("NOTIFICATIONS_BELL_ICON element is not displayed on the page!",
                homepage.getWebElement("NOTIFICATIONS_BELL_ICON").isDisplayed());
        Assert.assertTrue("CUSTOMER_SERVICE element is not displayed on the page!",
                homepage.getWebElement("CUSTOMER_SERVICE").isDisplayed());
        Assert.assertTrue("HEADER_NAVIGATION element is not displayed on the page!",
                homepage.getWebElement("HEADER_NAVIGATION").isDisplayed());
    }

    @After
    public void cleanUp() {
        Driver.destroy();
    }
}
