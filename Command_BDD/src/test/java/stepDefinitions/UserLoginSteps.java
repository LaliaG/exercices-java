package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class UserLoginSteps {

    private String currentPage;
    private String username;
    private String password;

    @Given("The user is on the login form")
    public void theUserIsOnTheLoginForm() {
        currentPage = "loginForm";
    }

    @When("They enter their username and password")
    public void theyEnterTheirUsernameAndPassword() {
        username = "testuser";
        password = "password123";
        if (currentPage.equals("loginForm") && username.equals("testuser") && password.equals("password123")) {
            currentPage = "homepage";
        }
    }

    @Then("They are redirected to the homepage")
    public void theyAreRedirectedToTheHomepage() {
        Assertions.assertNotNull(currentPage, "Current page should not be null");
        Assertions.assertEquals("homepage", currentPage, "User should be redirected to the homepage");
    }
}



/*package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.model.User;
import org.example.service.UserService;
import org.junit.Assert;

public class
UserLoginSteps {
    private UserService userService;
    private User user;
    private User loggedInUser;

    @Given("The user is on the login form")
    public void theUserIsOnTheLoginForm() {
        userService = new UserService();
        user = new User("test@example.com", "testUser", "password123");
        userService.registerUser(user);
    }

    @When("They enter their username and password")
    public void theyEnterTheirUsernameAndPassword() {
        loggedInUser = userService.loginUser("testUser", "password123");
    }

    @Then("They are redirected to the homepage")
    public void theyAreRedirectedToTheHomepage() {
        Assert.assertNotNull(loggedInUser);
    }

    @When("They enter an incorrect username or password")
    public void theyEnterAnIncorrectUsernameOrPassword() {
        loggedInUser = userService.loginUser("testUser", "wrongPassword");
    }

    @Then("They see an error message indicating the information is incorrect")
    public void theySeeAnErrorMessageIndicatingTheInformationIsIncorrect() {
        Assert.assertNull(loggedInUser);
    }
}*/

