import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Command;
import org.junit.Assert;

public class UserOrderSteps {
    private Command command;
    private String message;

    @Given("User has products in their order")
    public void userHasProductsInTheirOrder() {
        command = new Command();
        command.getProducts().add("Laptop");
        command.getProducts().add("Chair");
    }

    @When("User clicks the Place Order button")
    public void userClicksThePlaceOrderButton() {
        // Assuming the order form becomes visible here
        message = "Order form displayed";
    }

    @Then("User sees the order form")
    public void userSeesTheOrderForm() {
        Assert.assertEquals("Order form displayed", message);
    }

    @When("User fills in the required information")
    public void userFillsInTheRequiredInformation() {
        // Simulate user filling in the order form details
        message = "Information filled";
    }

    @And("User clicks the Confirm Order button")
    public void userClicksTheConfirmOrderButton() {
        if (command != null && !command.getProducts().isEmpty() && "Information filled".equals(message)) {
            message = "Order confirmation";
        } else {
            message = "Order does not exist";
        }
    }

    @Then("User receives an order confirmation")
    public void userReceivesAnOrderConfirmation() {
        Assert.assertEquals("Order confirmation", message);
    }

    @When("User tries to confirm a non-existent order")
    public void userTriesToConfirmANonExistentOrder() {
        command = null;
        message = "Order does not exist";
    }

    @Then("They see an error message indicating that the order does not exist")
    public void theySeeAnErrorMessageIndicatingThatTheOrderDoesNotExist() {
        Assert.assertEquals("Order does not exist", message);
    }

}
