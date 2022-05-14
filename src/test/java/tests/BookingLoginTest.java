package tests;

import driver.Driver;
import org.junit.Assert;
import pages.booking.BookingHomepage;
import pages.booking.BookingMainPage;
import pages.booking.login.BookingSignInEmailPage;
import pages.booking.login.BookingSignInPasswordPage;

public class BookingLoginTest {

    BookingMainPage mainPage = new BookingMainPage();
    BookingSignInEmailPage signInEmailPage = new BookingSignInEmailPage();
    BookingSignInPasswordPage signInPasswordPage = new BookingSignInPasswordPage();
    BookingHomepage homepage = new BookingHomepage();

    public void getMainpage() {
        Driver.getWebDriver().get("https://www.booking.com/");
    }

    public void signIn() {
        mainPage.clickSignIn();
    }

    public void inputEmail() {
        signInEmailPage.inputEmail();
    }

    public void inputPassword() {
        signInPasswordPage.inputPassword();
    }

    public void login() {
        signInPasswordPage.signIn();
    }

    public void verifyBookingLogoPresent() {
        Assert.assertNotNull("Booking logo is absent.", homepage.getBookingLogoElement());
    }

    public void verifyLanguageIconPresent() {
        Assert.assertTrue("Language icon is absent.", homepage.getLanguageElement().isDisplayed());
    }

    public void verifyCurrencyIconPresent() {
        Assert.assertTrue("Currency icon is absent.", homepage.getCurrencyElement().isDisplayed());
    }

    public void verifyCustomerServicePresent() {
        Assert.assertTrue("Customer service icon is absent.",
                homepage.getCustomerServiceElement().isDisplayed());
    }

    public void verifyNotificationsBellIconIsDisplayed() {
        Assert.assertTrue("Notifications bell icon is absent on the page.",
                homepage.getNotificationsBell().isDisplayed());
    }

    public void verifyPropertyIconIsDisplayed() {
        Assert.assertTrue("Property icon is absent on the page.", homepage.getPropertyIcon().isDisplayed());
    }

    public void verifyHeaderNavigationIsDisplayed() {
        Assert.assertTrue("Header navigation element is absent on the page.",
                homepage.getHeaderNavigation().isDisplayed());
    }
}
