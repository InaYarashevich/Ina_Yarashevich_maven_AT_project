package steps.booking.base;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.booking.*;
import pages.booking.login.BookingSignInEmailPage;
import pages.booking.login.BookingSignInPasswordPage;
import pages.booking.registration.BookingRegisterEmailPage;
import pages.booking.registration.BookingRegisterPasswordPage;
import pages.booking.results.BookingFilteredResultPage;
import pages.booking.results.BookingResultPage;
import pages.booking.results.BookingSortedResultPage;

public class Steps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingResultPage resultPage = new BookingResultPage();
    BookingFilteredResultPage filteredResultPage = new BookingFilteredResultPage();
    BookingSortedResultPage sortedResultPage = new BookingSortedResultPage();
    BookingRegisterEmailPage registerEmailPage = new BookingRegisterEmailPage();
    BookingRegisterPasswordPage registerPasswordPage = new BookingRegisterPasswordPage();
    BookingHomepage homepage = new BookingHomepage();
    BookingSignInEmailPage signInEmailPage = new BookingSignInEmailPage();
    BookingSignInPasswordPage signInPasswordPage = new BookingSignInPasswordPage();
    BookingWishlistPage wishlistPage = new BookingWishlistPage();

    @Given("I open Booking main page")
    public void iOpenBookingPage() {
        Driver.getWebDriver().get("https://www.booking.com/");
    }

    @When("I fill {string}  in the field")
    public void iFillInTheField(String cityName) {
        mainPage.searchCity(cityName);
    }

    @And("I select check in date")
    public void iSelectCheckInDate() {
        mainPage.selectCheckInDate();
    }

    @And("I select checkout date")
    public void iSelectCheckoutDate() {
        mainPage.selectCheckoutDate();
    }

    @And("I select the number of the adults")
    public void iSelectTheNumberOfTheAdults() {
        mainPage.selectNumberOfAdults();
    }

    @And("I select the number of the rooms")
    public void iSelectTheNumberOfTheRooms() {
        mainPage.selectNumberOfRooms();
    }

    @And("I click on the Search button")
    public void iClickOnTheSearchButton() {
        mainPage.search();
    }

    @And("I filter the list of the found hotels by the max price per night")
    public void iFilterTheListOfTheFoundHotelsByTheMaxPricePerNight() {
        resultPage.filterResults();
    }

    @And("I sort the list of the results by the lowest price")
    public void iSortTheListOfTheResultsByTheLowestPrice() {
        filteredResultPage.sortByLowestPrice();
    }

    @Then("I see the list of the hotels with max price per night")
    public void iSeeTheListOfTheHotelsWithMaxPricePerNight() {
        Assert.assertTrue("The actual hotel price is less than the expected max price.",
                sortedResultPage.getHotelPrice() >= sortedResultPage.getMaxPrice());
    }

    @Then("I see the list of the hotels")
    public void iSeeTheListOfTheHotels() {
        Assert.assertFalse("The are no hotels' results.", resultPage.getResults().isEmpty());
    }

    @After
    public void after() {
        Driver.destroy();
    }

    @When("I hover on currency icon")
    public void iHoverOnCurrencyIcon() {
        mainPage.getCurrencyTooltipText();
    }

    @Then("I see the currency element tooltip appears")
    public void iSeeTheCurrencyElementTooltipAppears() {
        Assert.assertEquals("The currency tooltip text is incorrect!",
                mainPage.getCurrencyTooltipText(), mainPage.getCurrencyTooltipText());
    }

    @When("I hover on language icon")
    public void iHoverOnLanguageIcon() {
        mainPage.getLanguageTooltipText();
    }

    @Then("I see the language element tooltip appears")
    public void iSeeTheLanguageElementTooltipAppears() {
        Assert.assertEquals("The language tooltip text is incorrect!",
                mainPage.getLanguageTooltipText(), mainPage.getLanguageTooltipText());
    }

    @When("I click on Register button")
    public void clickOnRegisterButton() {
        mainPage.initRegistration();
    }

    @And("I input Email address")
    public void inputAddress() {
        registerEmailPage.inputEmail();
    }

    @And("I click on Continue with email")
    public void clickOnContinueWithEmail() {
        registerEmailPage.submitEmail();
    }

    @And("I input Password")
    public void input() {
        registerPasswordPage.inputPassword();
    }

    @And("I confirm Password")
    public void confirm() {
        registerPasswordPage.confirmPassword();
    }

    @And("I click on Create Account")
    public void clickOnCreateAccount() {
        registerPasswordPage.createAccount();
    }

    @Then("I see the 'Welcome to Booking.com!' greeting modal")
    public void iSeeTheBookingMainPageWithTheWelcomeToBookingComGreeting() {
        Assert.assertNotNull("There is no greeting message!", homepage.getGreeting());
    }

    @When("I click on Sign in button")
    public void iClickOnSignInButton() {
        mainPage.clickSignIn();
    }

    @And("I input email")
    public void iInputEmail() {
        signInEmailPage.inputEmail();
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        signInEmailPage.submitEmail();
    }

    @And("I input password")
    public void iInputPassword() {
        signInPasswordPage.inputPassword();
    }

    @And("I click on SignIn")
    public void iClickOnSignIn() {
        signInPasswordPage.signIn();
    }

    @Then("The Booking logo element is displayed")
    public void theHeaderElementsAreDisplayed() {
        Assert.assertTrue("Booking logo is absent!", homepage.getBookingLogoElement().isDisplayed());
    }

    @Then("Profile menu button is displayed")
    public void profileMenuButtonIsDisplayed() {
        Assert.assertTrue("Profile menu is absent!", homepage.getProfileMenu().isDisplayed());
    }

    @Then("Language icon is displayed")
    public void languageIconIsDisplayed() {
        Assert.assertTrue("Language icon is absent.", homepage.getLanguageElement().isDisplayed());
    }

    @Then("Currency icon is displayed")
    public void currencyIconIsDisplayed() {
        Assert.assertTrue("Currency icon is absent.", homepage.getCurrencyElement().isDisplayed());
    }

    @Then("Customer service icon is displayed")
    public void customerServiceIconIsDisplayed() {
        Assert.assertTrue("Customer service icon is absent.", homepage.getCustomerServiceElement().isDisplayed());
    }

    @Then("Notifications bell icon is displayed")
    public void notificationsBellIconIsDisplayed() {
        Assert.assertTrue("Notifications bell icon is absent on the page.",
                homepage.getNotificationsBell().isDisplayed());
    }

    @Then("Property icon is displayed")
    public void propertyIconIsDisplayed() {
        Assert.assertTrue("Property icon is absent on the page.", homepage.getPropertyIcon().isDisplayed());
    }

    @Then("Header navigation is displayed")
    public void headerNavigationIsDisplayed() {
        Assert.assertTrue("Header navigation element is absent on the page.",
                homepage.getHeaderNavigation().isDisplayed());
    }

    @And("Homepage is opened")
    public void homepageIsOpened() {
        homepage.getHomepage();
    }

    @And("I save the first item in the list to wishlist")
    public void iSaveTheFirstItemInTheListToWishlist() {
        resultPage.addToWishlist(0);
    }

    @And("I save the last item in the list to wishlist")
    public void iSaveTheLastItemInTheListToWishlist() {
        resultPage.addToWishlist(24);
    }

    @And("I open wishlist")
    public void iOpenWishlist() {
        resultPage.navigateToWishlist();
    }

    @Then("I see the first saved item on the page")
    public void iSeeTheStSavedItemOnThePage() {
      Assert.assertTrue("Saved hotel is not displayed in the wishlist.",
              wishlistPage.getSavedHotelTitle(1).equalsIgnoreCase(resultPage.getHotelTitle(0)));
    }

    @Then("I see the last saved item on the page")
    public void iSeeTheLastSavedItemOnThePage() {
        Assert.assertTrue("Saved hotel is not displayed in the wishlist.",
                wishlistPage.getSavedHotelTitle(0).equalsIgnoreCase(resultPage.getHotelTitle(24)));
    }
}
