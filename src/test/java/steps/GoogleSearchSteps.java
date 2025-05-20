// src/test/java/steps/GoogleSearchSteps.java
package steps;


import io.cucumber.java.en.*;
import pages.GoogleSearchActions;
import utils.TestDataReader;

import static org.junit.Assert.assertTrue;

public class GoogleSearchSteps {
    private GoogleSearchActions googleSearchActions;
    private String searchTerm = TestDataReader.getSearchTerm();

    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
        Hooks.driver.get("https://www.google.com");
        googleSearchActions = new GoogleSearchActions(Hooks.driver);
    }

    @When("I type the search term from json")
    public void i_type_the_search_term_from_json() {
        googleSearchActions.enterSearchTerm(searchTerm);
    }

    @Then("I should see results related to Automation")
    public void i_should_see_results_related_to_automation() {
        assertTrue(Hooks.driver.getTitle().toLowerCase().contains("automation"));
    }
}