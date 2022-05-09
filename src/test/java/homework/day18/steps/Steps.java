package homework.day18.steps;

import classwork.day18.Driver;
import homework.day18.pages.booking.BookingFilteredResultPage;
import homework.day18.pages.booking.BookingMainPage;
import homework.day18.pages.booking.BookingResultPage;
import homework.day18.pages.booking.BookingSortedResultPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Steps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingResultPage resultPage = new BookingResultPage();
    BookingFilteredResultPage filteredResultPage = new BookingFilteredResultPage();
    BookingSortedResultPage sortedResultPage = new BookingSortedResultPage();

    @Given("I open Booking page")
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
}
