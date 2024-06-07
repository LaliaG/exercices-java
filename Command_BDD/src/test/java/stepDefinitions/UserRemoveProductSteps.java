package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exception.ProductNotFoundException;
import org.example.model.Command;
import org.example.model.Product;
import org.example.service.CommandService;
import org.junit.Assert;

public class UserRemoveProductSteps {
    private CommandService commandService;
    private Command command;
    private Product product;
    private String errorMessage;

    @Given("The product is in the order")
    public void theProductIsInTheOrder() {
        commandService = new CommandService();
        command = new Command();
        product = new Product("Laptop", "Electronics", 999.99);
        commandService.addProductToCommand(command, product);
    }

    @When("The user clicks the {string} button for that product")
    public void theUserClicksTheButtonForThatProduct(String button) {
        try {
            commandService.removeProductFromCommand(command, product);
        } catch (ProductNotFoundException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("The quantity of the product in the order is decreased by {int}")
    public void theQuantityOfTheProductInTheOrderIsDecreasedBy(Integer quantity) {
        Assert.assertFalse(command.getProducts().containsKey(product));
    }

    @Given("The product is not in the order")
    public void theProductIsNotInTheOrder() {
        command = new Command();
    }

    @Then("They see an error message indicating that the product is not in the order")
    public void theySeeAnErrorMessageIndicatingThatTheProductIsNotInTheOrder() {
        Assert.assertEquals("Product not found in command", errorMessage);
    }
}
