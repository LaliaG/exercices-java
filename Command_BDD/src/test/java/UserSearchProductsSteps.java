import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Product;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class UserSearchProductsSteps {
    private List<Product> products;
    private List<Product> searchResults;

    @Given("User is on the homepage with products")
    public void userIsOnTheHomepageWithProducts() {
        products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics"));
        products.add(new Product("Chair", "Furniture"));
        products.add(new Product("Notebook", "Stationery"));
    }

    @When("User enters a keyword {string} in the search bar")
    public void userEntersAKeywordInTheSearchBar(String keyword) {
        searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(product);
            }
        }
    }

    @Then("User sees a list of relevant search results")
    public void userSeesAListOfRelevantSearchResults() {
        Assert.assertFalse(searchResults.isEmpty());
    }
}
