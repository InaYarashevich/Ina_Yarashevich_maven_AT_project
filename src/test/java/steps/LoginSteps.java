package steps;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends BaseSteps {

    @Given("I open Booking main page")
    public void iOpenBookingMainPage() {
        Driver.getWebDriver().get("https://www.booking.com/");
    }

    @When("I click on Sign in button")
    public void iClickOnSignInButton() {
        mainPage.clickSignIn();
    }

    @And("I sign in with {string} and {string}")
    public void iSignInWithAnd(String email, String password) {
        signInPage.signIn(email, password);
    }

    @Then("I see {string} element")
    public void iSeeElements(String element) {
        Assert.assertTrue(String.format("% element is not displayed on the page!", element),
                homepage.getWebElement(element).isDisplayed());
    }

    @After
    public void after() {
        Driver.destroy();
    }
}
