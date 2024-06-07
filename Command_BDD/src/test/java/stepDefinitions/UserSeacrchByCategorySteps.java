package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSeacrchByCategorySteps {
    @Given("The user is on the search page")
    public void theUserIsOnTheSearchPage() {
    }

    @When("The user selects a category from the category list")
    public void theUserSelectsACategoryFromTheCategoryList() {
    }

    @Then("The user sees a list of products in that category")
    public void theUserSeesAListOfProductsInThatCategory() {
    }

    @When("The user selects a non-existent category from the category list")
    public void theUserSelectsANonExistentCategoryFromTheCategoryList() {
    }

    @Then("They see an error message indicating that the category does not exist")
    public void theySeeAnErrorMessageIndicatingThatTheCategoryDoesNotExist() {
    }
}
