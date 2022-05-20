package steps;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegistrationSteps extends BaseSteps {

    @Given("I register temporary email using my mail.ru {string} account")
    public void iRegisterTemporaryEmailUsingMyMailRuAccount(String realEMail) {
        creatingTempMail.createTempMail(realEMail);
    }

    @Given("I open Booking page")
    public void iOpenBookingPage() {
        Driver.getWebDriver().get("https://www.booking.com/");
    }

    @When("I click on Register button")
    public void clickOnRegisterButton() {
        mainPage.startRegistration();
    }

    @And("I register with my {string} and {string} password")
    public void iRegisterWithMyTemporaryEmailAndPassword(String email, String password) {
        registrationPage.register(email, password);
    }

    @And("I log in to mail.ru \\({string}, {string}) and confirm registration in {string} email")
    public void iLogInToMailRuAndConfirmRegistrationInEmail(String accountName, String password, String emailSubject) {
        mailConfirmation.confirmRegistration(accountName, password, emailSubject);
    }

    @And("I login with confirmed {string} and {string}")
    public void iLoginWithConfirmedAnd(String email, String password) {
        mainPage.clickSignIn();
        signInPage.signIn(email, password);
    }

    @And("I open Account settings page")
    public void iOpenAccountSettingsPage() {
        homepage.getAccountSettingsPage();
    }

    @And("I open Personal details page")
    public void iOpenPersonalDetailsPage() {
        accountSettingsPage.getPersonalDetailsPage();
    }

    @Then("I see Verified label near the email")
    public void iSeeVerifiedLabelNearTheEmail() {
        Assert.assertTrue("Email is not verified.", personalDetailsPage.getEmailStatus().isDisplayed());
    }

    @After
    public void after() {
        Driver.destroy();
    }
}
