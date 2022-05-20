package tests;

import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.booking.BookingHomepage;
import pages.booking.BookingMainPage;
import pages.booking.login.BookingSignInPage;
import utils.CreatingTempMail;


public class BookingLoginTest {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSignInPage signInPage = new BookingSignInPage();
    BookingHomepage homepage = new BookingHomepage();
    CreatingTempMail tempMail = new CreatingTempMail();

    private static final Logger LOGGER =
            Logger.getLogger(BookingLoginTest.class.getName());

    @Test
    public void bookingLoginWithEmailPassword() {
        Driver.getWebDriver().manage().window().maximize();
        String email = tempMail.createTempMail("jane.doe2022@mail.ru");
        Driver.getWebDriver().get("https://www.booking.com/");
        mainPage.clickSignIn();
        signInPage.signIn(email, "Automation2022!");
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
