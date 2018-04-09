package lk.pontusfa.fullhund;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class AppTest {
    @Test
    void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(true));
        assertNull(classUnderTest.getGreeting(false));
    }
}
