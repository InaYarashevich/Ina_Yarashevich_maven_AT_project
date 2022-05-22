package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class HotelsSearchSteps extends BaseSteps{

    @When("I fill {string}  in the field")
    public void iFillInTheField(String cityName) {
        mainPage.searchCity(cityName);
    }

    @And("I select check in date")
    public void iSelectCheckInDate() {
        mainPage.selectCheckInDate();
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

    @And("I select next month date from now as check in date")
    public void iSelectNextMonthDateFromNowAsCheckInDate() {
        mainPage.selectCheckInDate();
    }

    @And("I select checkout date to stay for {int} days")
    public void iSelectCheckoutDateToStayForDays(int daysToStay) {
        mainPage.selectCheckoutDate(daysToStay);
    }
}
