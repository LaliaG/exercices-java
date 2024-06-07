package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exception.CommandNotFoundException;
import org.example.model.Command;
import org.example.model.Product;
import org.example.service.CommandService;
import org.junit.Assert;

public class UserOrderSteps {
    private CommandService commandService;
    private Command command;

    @When("They click the confirm order button")
    public void theyClickTheConfirmOrderButton() {
        // Ajoutez la logique pour confirmer la commande
    }

    @Then("They see a confirmation that the order has been placed")
    public void theySeeAConfirmationThatTheOrderHasBeenPlaced() {
        // Ajoutez les assertions pour vérifier la confirmation
    }
   /* private CommandService commandService;
    private Command command;
    private String orderConfirmation;
    private String errorMessage;

    @Given("The user has products in their order")
    public void theUserHasProductsInTheirOrder() {
        commandService = new CommandService();
        command = new Command();
        commandService.addProductToCommand(command, new Product("Laptop", "Electronics", 999.99));
    }

    @When("They click the {string} button")
    public void theyClickTheButton(String button) {
        // Logic to simulate button click (if needed)
    }

    @Then("They see the order form")
    public void theySeeTheOrderForm() {
        // Logic to verify the order form is visible
    }

    @When("They fill in the required information")
    public void theyFillInTheRequiredInformation() {
        // Logic to fill in the required information (if needed)
    }

    @When("They click the {string} button")
    public void theyClickTheConfirmOrderButton(String button) {
        try {
            orderConfirmation = commandService.placeOrder(command);
        } catch (CommandNotFoundException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("They receive an order confirmation")
    public void theyReceiveAnOrderConfirmation() {
        Assert.assertEquals("Order placed successfully", orderConfirmation);
    }

    @Given("The user tries to confirm a non-existent order")
    public void theUserTriesToConfirmANonExistentOrder() {
        command = new Command();
    }

    @Then("They see an error message indicating that the order does not exist")
    public void theySeeAnErrorMessageIndicatingThatTheOrderDoesNotExist() {
        Assert.assertEquals("Order does not exist", errorMessage);
    }*/
}
