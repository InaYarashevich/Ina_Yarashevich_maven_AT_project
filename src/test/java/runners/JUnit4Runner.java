package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.api.JokesTest;
import tests.api.SearchTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({SearchTest.class,
        JokesTest.class
})

public class JUnit4Runner {
}
