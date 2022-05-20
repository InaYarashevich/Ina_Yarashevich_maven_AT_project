package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BookingLoginTest;
import tests.BookingRegistrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingLoginTest.class,
        BookingRegistrationTest.class
})

public class JUnit4Runner {
}
