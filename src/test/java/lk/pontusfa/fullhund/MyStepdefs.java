package lk.pontusfa.fullhund;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class MyStepdefs {
    @When("^I run a failing step$")
    public void iRunAFailingStep() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I run a failing step1$")
    public void iRunAFailingSte1() {
    }
}
