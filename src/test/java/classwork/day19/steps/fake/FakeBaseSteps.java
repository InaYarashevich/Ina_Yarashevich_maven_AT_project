package classwork.day19.steps.fake;

import driver.Config;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class FakeBaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    /*@Before
    public void beforeTest(){
        LOGGER.info("Start test");
        Driver.setConfig(Config.REMOTE);
    }

    @After
    public void afterTest(){
        LOGGER.info("Killing WebDriver");
        Driver.destroy();
    }*/
}
