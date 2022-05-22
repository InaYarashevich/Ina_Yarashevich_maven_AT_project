package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Steps extends BaseSteps{
    @Then("I see the list of the hotels")
    public void iSeeTheListOfTheHotels() {
        Assert.assertFalse("The are no hotels' results.", searchResultPage.getResults().isEmpty());
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
    @And("I save the {int} item in the list to wishlist")
    public void iSaveTheFirstItemInTheListToWishlist(int item) {
        searchResultPage.addToWishlist(item);
    }
    @And("I open wishlist")
    public void iOpenWishlist() {
        searchResultPage.navigateToWishlist();
    }

    @Then("I see the first saved item on the page")
    public void iSeeTheStSavedItemOnThePage() {
      Assert.assertTrue("Saved hotel is not displayed in the wishlist.",
              wishlistPage.getSavedHotelTitle(1).equalsIgnoreCase(searchResultPage.getHotelTitle(0)));
    }

    @Then("I see the last saved item on the page")
    public void iSeeTheLastSavedItemOnThePage() {
        Assert.assertTrue("Saved hotel is not displayed in the wishlist.",
                wishlistPage.getSavedHotelTitle(0).equalsIgnoreCase(searchResultPage.getHotelTitle(24)));
    }

}
