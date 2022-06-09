package steps.gui;

import driver.Config;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import objects.gui.SearchResults;
import org.apache.log4j.Logger;
import org.junit.Assert;
import tests.gui.BookingHotelRatingTest;

import java.net.MalformedURLException;

public class SearchResultsSteps extends BaseSteps{

    private static final Logger LOGGER =
            Logger.getLogger(BookingHotelRatingTest.class.getName());

    public SearchResultsSteps() throws MalformedURLException {
    }

    @Before
    public void beforeTest(){
        LOGGER.info("Start test");
        Driver.setConfig(Config.CHROME);
    }

    @After
    public void afterTest(){
        LOGGER.info("Killing WebDriver");
        Driver.destroy();
    }

    @And("I filter hotels by {string} rating")
    public void iFilterHotelsByRating(String rating) {
        searchResultPage.filterResultsByRating(rating);
    }

    @Then("I see hotel with selected rating")
    public void iSeeHotelWithSelectedRating() {
        Assert.assertTrue("The actual hotel rating is less than the expected max hotel rating.",
                searchResultPage.getHotelRating() >= searchResultPage.getHotelRating());
    }

    @And("I open detailed page of the ([0-9])-st hotel")
    public void iOpenDetailedPageOfTheHotel(int hotelOrderNumber) {
        searchResultPage.openHotelDetailsPage(hotelOrderNumber);
    }

    @And("I filter the list of the found hotels by the {string} price per night")
    public void iFilterTheListOfTheFoundHotelsByTheMaxPricePerNight(String price) {
        searchResultPage.filterResultsByPrice(price);
    }

    @And("I sort the list of the results by the lowest price")
    public void iSortTheListOfTheResultsByTheLowestPrice() {
        searchResultPage.sortByLowestPrice();
    }

    @Then("I see the list of the hotels with max price per night")
    public void iSeeTheListOfTheHotelsWithMaxPricePerNight() {
        Assert.assertTrue("The actual hotel price is less than the expected max price.",
                searchResultPage.getHotelPrice() >= new SearchResults().getPrice());
    }
}
