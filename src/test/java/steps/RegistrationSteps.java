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

    @And("I open mail.ru")
    public void iOpenMailRu() {
        Driver.getWebDriver().get("https://mail.ru/");
    }

    @And("I log in with {string}, {string}")
    public void iLogWith(String email, String password) {
        mailRuMainPage.loginMailRu(email, password);
    }

    @And("I open email with {string} subject")
    public void iOpenEmailWithSubject(String subject) {
        mailRuInboxFolderPage.openEmail(subject);
    }

    @And("I confirm registration on Booking")
    public void iConfirmRegistrationOnBooking() {
        mailRuInboxFolderPage.confirmEmail();
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
}
