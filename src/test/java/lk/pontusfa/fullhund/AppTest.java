package lk.pontusfa.fullhund;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {
    @Test
    void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(true));
    }
}
