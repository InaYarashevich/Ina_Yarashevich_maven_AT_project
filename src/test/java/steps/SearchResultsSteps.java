package steps;

import driver.Config;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import tests.BookingHotelRatingTest;

public class SearchResultsSteps extends BaseSteps{

    private static final Logger LOGGER =
            Logger.getLogger(BookingHotelRatingTest.class.getName());

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

    @And("I filter the list of the found hotels by the max price per night")
    public void iFilterTheListOfTheFoundHotelsByTheMaxPricePerNight() {
        searchResultPage.filterResultsByMaxPrice();
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
}
