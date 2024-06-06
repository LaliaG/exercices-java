import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.User;
import org.junit.Assert;

public class UserRegisterSteps {
    private User user;
    private String message;

    @Given("User is on the registration form")
    public void userIsOnTheRegistrationForm() {
        user = new User("", "", "");
    }

    @When("User enters {string}, {string}, and {string}")
    public void userEnters(String username, String email, String password) {
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
    }

    @And("User clicks the Sign Up button")
    public void userClicksTheSignUpButton() {
        if (emailAlreadyExists(user.getEmail())) {
            message = "Email already used";
        } else {
            message = "Registration successful";
        }
    }

    @Then("User receives a registration confirmation")
    public void userReceivesARegistrationConfirmation() {
        Assert.assertEquals("Registration successful", message);
    }

    @Then("User sees an error message indicating that the email is already used")
    public void userSeesAnErrorMessageIndicatingThatTheEmailIsAlreadyUsed() {
        Assert.assertEquals("Email already used", message);
    }

    private boolean emailAlreadyExists(String email) {
        // This is a placeholder for actual email check logic
        return false; // Change this to simulate email existence check
    }



}
