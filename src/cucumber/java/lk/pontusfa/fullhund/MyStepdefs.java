package lk.pontusfa.fullhund;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.math.Fraction;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyStepdefs {
    @When("^I run a failing step$")
    public void iRunAFailingStep() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I run a failing step1$")
    public void iRunAFailingSte1() {
        App classUnderTest = new App();
        System.out.println(Fraction.getFraction("1/3"));
        assertNotNull(classUnderTest.getGreeting());
        System.out.println(classUnderTest.getGreeting());
    }

    @When("^apa$")
    public void apa() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
