package classwork.day19.suites.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
      //  plugin = {"pretty", "summary"},
       // glue = {"classwork.day19.steps.fake"},
       // features = {"src/test/resources/features/fake/FakeTwo.feature"}
)
public class FakeRunner2 {
}
