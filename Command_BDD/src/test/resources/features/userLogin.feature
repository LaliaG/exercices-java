Feature: User login

  Scenario: Successful login
    Given The user is on the login form
    When They enter their username and password
    Then They are redirected to the homepage

  Scenario: Unsuccessful login
    Given The user is on the login form
    When They enter an incorrect username or password
    Then They see an error message indicating the information is incorrect

