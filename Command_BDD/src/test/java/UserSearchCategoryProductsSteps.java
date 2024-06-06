import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Product;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class UserSearchCategoryProductsSteps {
    private List<Product> products;
    private List<Product> categoryResults;

    @Given("User is on the categories page with products")
    public void userIsOnTheCategoriesPageWithProducts() {
        products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics"));
        products.add(new Product("Chair", "Furniture"));
        products.add(new Product("Notebook", "Stationery"));
    }

    @When("User clicks on category {string}")
    public void userClicksOnCategory(String category) {
        categoryResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                categoryResults.add(product);
            }
        }
    }

    @Then("User sees a list of products corresponding to that category")
    public void userSeesAListOfProductsCorrespondingToThatCategory() {
        Assert.assertFalse(categoryResults.isEmpty());
    }

}
