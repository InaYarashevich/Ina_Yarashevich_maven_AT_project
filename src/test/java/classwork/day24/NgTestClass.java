package classwork.day24;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyTestNGListener.class)
public class NgTestClass {

    private static final Logger LOGGER = LogManager.getLogger(NgTestClass.class);

    @Test (description = "84651")
    public void firstTest(){
        LOGGER.info("Executing firstTest");
        Assert.assertTrue(true);
    }

    @Test (description = "84652")
    public void secondTest(){
        LOGGER.info("Executing secondTest");
        Assert.assertTrue(false);
    }
}
