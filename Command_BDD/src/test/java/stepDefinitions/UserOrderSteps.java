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
import org.junit.jupiter.api.Assertions;

public class UserOrderSteps {

   private CommandService commandService;


    public UserOrderSteps() {
        this.commandService = new CommandService(); // ou utilisez l'injection de dépendance
    }
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

    @When("they click the confirm order button")
    public void theyClickTheConfirmOrderButton() {
        // Votre implémentation ici
        System.out.println("Confirm order button clicked");
    }

    @Then("They receive an order confirmation")
    public void theyReceiveAnOrderConfirmation() {
        String confirmationMessage = commandService.getOrderConfirmation(command); // Assurez-vous que cette méthode retourne bien "Order placed successfully"
        Assert.assertEquals("Order placed successfully", confirmationMessage);
    }

    @Then("They see an error message indicating that the order does not exist")
    public void theySeeAnErrorMessageIndicatingThatTheOrderDoesNotExist() {
        Command command = getNonExistentOrder(); // Supposons que cela obtient la commande inexistante
        String errorMessage = commandService.getOrderErrorMessage(command);
        Assertions.assertNotNull(errorMessage, "Error message should not be null");
        Assertions.assertEquals("Order does not exist", errorMessage);
    }

    private Command getNonExistentOrder() {
        // Simulation ou implémentation réelle pour obtenir une commande inexistante
        return new Command(); // Placeholder
    }
/*
    @Then("They see an error message indicating that the order does not exist")
    public void theySeeAnErrorMessageIndicatingThatTheOrderDoesNotExist() {
        String errorMessage = commandService.getOrderErrorMessage(command); // Assurez-vous que cette méthode retourne bien "Order does not exist"
        Assert.assertNotNull(errorMessage);
        Assert.assertEquals("Order does not exist", errorMessage);
    }*/

    /*
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
*/
    @Given("The user tries to confirm a non-existent order")
    public void theUserTriesToConfirmANonExistentOrder() {
        command = new Command();
    }
/*
    @Then("They see an error message indicating that the order does not exist")
    public void theySeeAnErrorMessageIndicatingThatTheOrderDoesNotExist() {
        Assert.assertEquals("Order does not exist", errorMessage);
    }*/
}
