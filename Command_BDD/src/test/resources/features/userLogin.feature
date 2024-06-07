Feature: User Login

  Scenario: Successful login
    Given The user is on the login form
    When They enter their username and password
    Then They are redirected to the homepage

