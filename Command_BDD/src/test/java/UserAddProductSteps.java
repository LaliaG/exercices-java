import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Command;
import org.example.Product;
import org.junit.Assert;

public class UserAddProductSteps {
    private Command command;
    private Product product;

    @Given("User is on a product page")
    public void userIsOnAProductPage() {
        command = new Command();
        product = new Product("Laptop", "Electronics");
    }

    @When("User clicks the Add to Order button")
    public void userClicksTheAddToOrderButton() {
        command.getProducts().add(product.getName());
    }

    @Then("User sees a confirmation that the product has been added to the order")
    public void userSeesAConfirmationThatTheProductHasBeenAddedToTheOrder() {
        Assert.assertTrue(command.getProducts().contains(product.getName()));
    }

    @Given("The product is already in the order")
    public void theProductIsAlreadyInTheOrder() {
        command.getProducts().add(product.getName());
    }

    @When("User clicks Add to Order for that product")
    public void userClicksAddToOrderForThatProduct() {
        command.getProducts().add(product.getName());
    }

    @Then("The quantity of the product in the order is increased by 1")
    public void theQuantityOfTheProductInTheOrderIsIncreasedBy() {
        long count = command.getProducts().stream().filter(p -> p.equals(product.getName())).count();
        Assert.assertEquals(2, count);
    }
}
