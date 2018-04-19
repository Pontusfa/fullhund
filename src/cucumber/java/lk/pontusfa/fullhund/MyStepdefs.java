package lk.pontusfa.fullhund;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyStepdefs {
    @When("^I run a failing step$")
    public void iRunAFailingStep() {
        throw new PendingException();
    }

    @When("^I run a failing step1$")
    public void iRunAFailingSte1() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting1(true));
    }

    @When("^apa$")
    public void apa() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
