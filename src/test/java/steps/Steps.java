package steps;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Steps extends BaseSteps{

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
        mainPage.clickSearch();
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
