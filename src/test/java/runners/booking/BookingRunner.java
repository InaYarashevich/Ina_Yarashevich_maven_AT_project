package runners.booking;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"steps"},
        features = {"src/test/resources/features/login.feature"},
        strict = true
        //tags = {"@QA"}
)

public class BookingRunner {

}
