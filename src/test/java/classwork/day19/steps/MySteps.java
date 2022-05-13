package classwork.day19.steps;

import classwork.day19.pages.BookingMainPage;
import classwork.day19.pages.BookingResultPage;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MySteps {

    BookingMainPage mainPage = new BookingMainPage();
    BookingResultPage resultPage = new BookingResultPage();

    @Given("I open test site")
    public void iOpenTestSite() {
        Driver.getWebDriver().get("https://www.booking.com/");
    }

    @When("I fill {string} into form")
    public void iFillIntoFrom(String city) {
        mainPage.searchCity(city);
    }

    @Then("I see greeting message")
    public void iSeeGreetingMessage() {
        Assert.assertTrue("Results count is not expected!", 25 == resultPage.getResults());
    }

    @After
    public void after(){
        Driver.destroy();
    }
}
