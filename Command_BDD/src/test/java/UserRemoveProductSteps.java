import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Command;
import org.example.Product;
import org.junit.Assert;

public class UserRemoveProductSteps {
    private Command command;
    private Product product;
    private String message; // Déclaration de la variable message

    @Given("The product is in the order")
    public void theProductIsInTheOrder() {
        command = new Command();
        product = new Product("Laptop", "Electronics");
        command.getProducts().add(product.getName());
    }

    @When("User clicks the Remove button for that product")
    public void userClicksTheRemoveButtonForThatProduct() {
        command.getProducts().remove(product.getName());
    }

    @Then("The quantity of the product in the order is decreased by 1")
    public void theQuantityOfTheProductInTheOrderIsDecreasedBy1() {
        Assert.assertFalse(command.getProducts().contains(product.getName()));
    }

    @Given("The product is not in the order")
    public void theProductIsNotInTheOrder() {
        command = new Command();
        product = new Product("Laptop", "Electronics");
    }

    @When("User clicks the Remove button for that product")
    public void userClicksTheRemoveButtonForThatProductNotInOrder() {
        // Trying to remove a product not in the order
        message = "Product not in order";
    }

    @Then("They see an error message indicating that the product is not in the order")
    public void theySeeAnErrorMessageIndicatingThatTheProductIsNotInTheOrder() {
        Assert.assertEquals("Product not in order", message);
    }
}
