Feature: Login

  Scenario: User accesses the login form
    Given The user is on the homepage
    When They click on the "Login" button
    Then They see the login form

  Scenario: User logs in with their username and password
    Given The user is on the login form
    When They enter their username and password
    And They click the "Login" button
    Then They are redirected to the homepage

  Scenario: Error when login fails
    Given The user is on the login form
    When They enter an incorrect username or password
    And They click the "Login" button
    Then They see an error message indicating the information is incorrect



