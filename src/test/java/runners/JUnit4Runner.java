package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BookingLoginTest;
import tests.BookingRegistrationTest;
import tests.BookingWishlistTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookingRegistrationTest.class
})

public class JUnit4Runner {
}
