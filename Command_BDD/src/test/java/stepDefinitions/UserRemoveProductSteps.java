package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exception.ProductNotFoundException;
import org.example.model.Command;
import org.example.model.Product;
import org.example.service.CommandService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class UserRemoveProductSteps {
    private Command command;
    private Product product;
    private final CommandService commandService;
    private String errorMessage;

    public UserRemoveProductSteps() {
        this.commandService = new CommandService(); // Initialize CommandService
    }

    @Given("The product is in the order")
    public void theProductIsInTheOrder() {
        command = new Command();

        product = new Product("Product1");
        command.addProduct(product, 1);
    }

    @Given("The product is not in the order")
    public void theProductIsNotInTheOrder() {
        command = new Command();
        product = new Product("Product1");
    }

    @When("The user clicks the {string} button for that product")
    public void theUserClicksTheButtonForThatProduct(String buttonName) {
        try {
            commandService.removeProductFromCommand(command, product);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("The quantity of the product in the order is decreased by {int}")
    public void theQuantityOfTheProductInTheOrderIsDecreasedBy(Integer quantity) {
        boolean product = command.getProduct(); // Remplacez par la logique pour obtenir le produit
        boolean isProductInOrder = command.isProductInOrder(product);
        Assert.assertFalse("Product should be removed from the order", isProductInOrder);
    }

    /*
    @Then("The quantity of the product in the order is decreased by {int}")
    public void theQuantityOfTheProductInTheOrderIsDecreasedBy(Integer quantity) {
        Assertions.assertFalse(command.getProducts().containsKey(product), "Product should be removed from the order");
    }
*/
    @Then("They see an error message indicating that the product is not in the order")
    public void theySeeAnErrorMessageIndicatingThatTheProductIsNotInTheOrder() {
        Assertions.assertNotNull(errorMessage, "Error message should not be null");
        Assertions.assertEquals("Product not in the order", errorMessage, "Error message should indicate that the product is not in the order");
    }
}
   /*private CommandService commandService;
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
}*/
