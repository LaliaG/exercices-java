import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.User;
import org.junit.Assert;

public class UserLoginSteps {
    private User user;
    private String message;

    @Given("User is on the login form")
    public void userIsOnTheLoginForm() {
        user = new User("testuser", "test@example.com", "password");
    }

    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        if (!username.equals(user.getUsername()) || !password.equals(user.getPassword())) {
            message = "Incorrect information";
        } else {
            message = "Login successful";
        }
    }

    @And("User clicks the Login button")
    public void userClicksTheLoginButton() {
        // Logic is handled in previous step
    }

    @Then("User is redirected to the homepage")
    public void userIsRedirectedToTheHomepage() {
        Assert.assertEquals("Login successful", message);
    }

    @Then("User sees an error message indicating the information is incorrect")
    public void userSeesAnErrorMessageIndicatingTheInformationIsIncorrect() {
        Assert.assertEquals("Incorrect information", message);
    }
}
