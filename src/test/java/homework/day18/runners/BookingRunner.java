package homework.day18.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"homework.day18"},
        features = {"src/test/resources/features/hotelsFilteringByPrice.feature",
                "src/test/resources/features/hotelsResults.feature",
                "src/test/resources/features/tooltips.feature"},
        strict = true
        //tags = {"@QA"}
)

public class BookingRunner {

}
