package lk.pontusfa.fullhund;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    @Test
    public void testAppHasAGreeting() {
        var classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting());
    }
}
