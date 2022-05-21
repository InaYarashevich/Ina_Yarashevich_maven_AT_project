package classwork.day19.steps.fake;

import driver.Config;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class FakeGuiSteps {

    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Given(value = "I go to booking.com")
    public void checkHeaderTest(){
        Driver.setConfig(Config.REMOTE);
        Driver.getWebDriver().get("https://booking.com");
    }

    @When("I start waiting")
    public void checkFooterTest(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I just passed")
    public void verify() {
        Assert.assertTrue(true);
    }
}
