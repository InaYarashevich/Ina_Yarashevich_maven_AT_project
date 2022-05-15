package steps;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegistrationSteps extends BaseSteps{

    @Given("I open Booking main page")
    public void iOpenBookingPage() {
        Driver.getWebDriver().get("https://www.booking.com/");
    }

    @When("I click on Register button")
    public void clickOnRegisterButton() {
        mainPage.initRegistration();
    }

    @And("I register with {string} and {string}")
    public void iRegisterWithAnd(String email, String password) {
        registrationPage.register(email, password);
    }

    @Then("I see the 'Welcome to Booking.com!' greeting modal")
    public void iSeeTheBookingMainPageWithTheWelcomeToBookingComGreeting() {
        Assert.assertNotNull("There is no greeting message!", homepage.getGreeting());
    }

    @After
    public void after() {
        Driver.destroy();
    }
}
