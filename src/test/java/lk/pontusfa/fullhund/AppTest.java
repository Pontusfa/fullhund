package lk.pontusfa.fullhund;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class AppTest {
    @Test
    void testAppHasAGreeting1() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting1(true));
        assertNull(classUnderTest.getGreeting1(false));
    }

    @Test
    void testAppHasAGreeting2() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting2(true));
        assertNull(classUnderTest.getGreeting2(false));
    }

    @Test
    void testAppHasAGreeting3() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting3(true));
        assertNull(classUnderTest.getGreeting3(false));
    }


}
