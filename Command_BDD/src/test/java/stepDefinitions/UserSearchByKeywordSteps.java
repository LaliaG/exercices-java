package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSearchByKeywordSteps {
    @When("The user enters a keyword in the search bar")
    public void theUserEntersAKeywordInTheSearchBar() {
    }

    @And("clicks the {string} button")
    public void clicksTheButton(String arg0) {
    }

    @Then("The user sees a list of products matching the keyword")
    public void theUserSeesAListOfProductsMatchingTheKeyword() {
    }

    @When("The user enters a non-existent keyword in the search bar")
    public void theUserEntersANonExistentKeywordInTheSearchBar() {
    }

    @Then("They see an error message indicating that no products match the keyword")
    public void theySeeAnErrorMessageIndicatingThatNoProductsMatchTheKeyword() {
    }
}
