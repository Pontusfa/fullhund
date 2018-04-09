package lk.pontusfa.fullhund;

import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    @Test
    public void testAppHasAGreeting() {
        App classUnderTest = new App();
        System.out.println(Fraction.getFraction("1/3"));

        assertNotNull(classUnderTest.getGreeting());
    }
}
