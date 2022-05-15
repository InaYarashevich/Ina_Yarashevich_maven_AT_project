package classwork.day19.steps.fake;


import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class FakeBaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Before
    public void beforeTest(){
        LOGGER.info("Start test");
    }

    @Given(value = "I go to booking.com")
    public void checkHeaderTest(){
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
    public void verify(){
        Assert.assertTrue(true);
    }

    @After
    public void afterTest(){
        LOGGER.info("Killing WebDriver");
        Driver.destroy();
    }
}
