package steps.gui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class HotelsSearchSteps extends BaseSteps{

    public HotelsSearchSteps() throws MalformedURLException {
    }

    @When("I fill {string}  in the field")
    public void iFillInTheField(String cityName) {
        mainPage.searchCity(cityName);
    }

    @And("I select check in date")
    public void iSelectCheckInDate() {
        mainPage.selectCheckInDate();
    }

    @And("I select the {int} adults and {int} children")
    public void iSelectTheNumberOfTheAdults(int numOfAdults, int numOfChildren) {
        mainPage.selectNumberOfVisitors(numOfAdults, numOfChildren);
    }

    @And("I select the {int} rooms")
    public void iSelectTheNumberOfTheRooms(int numOfRooms) {
        mainPage.selectNumberOfRooms(numOfRooms);
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
