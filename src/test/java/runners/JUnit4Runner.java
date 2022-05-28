package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.api.JokesTestSuite;
import tests.api.SearchTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({SearchTest.class,
        JokesTestSuite.class
})

public class JUnit4Runner {
}
