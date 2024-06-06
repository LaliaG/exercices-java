Feature: Account Creation

  Scenario: User accesses the registration form
    Given The user is on the homepage
    When They click on the "Sign Up" button
    Then They see the registration form

  Scenario: User registers with an email, username, and password
    Given The user is on the registration form
    When They enter an email, username, and password
    And They click the "Sign Up" button
    Then They receive a registration confirmation

  Scenario: Error when creating an account with an already existing username
    Given The user is on the registration form
    When They enter an already used email
    And They click the "Sign Up" button
    Then They see an error message indicating that the email is already used









