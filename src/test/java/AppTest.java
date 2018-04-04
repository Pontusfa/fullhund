import lk.pontusfa.fullhund.App;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNull("app should have a greeting", classUnderTest.getGreeting());

    }
}
