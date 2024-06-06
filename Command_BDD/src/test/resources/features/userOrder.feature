Feature: Placing an Order

  Scenario: User accesses the order form
    Given The user has products in their order
    When They click the "Place Order" button
    Then They see the order form

  Scenario: User places an order
    Given The user is on the order form
    When They fill in the required information
    And They click the "Confirm Order" button
    Then They receive an order confirmation

  Scenario: Error if the order does not exist
    Given The user tries to confirm a non-existent order
    When They click the "Confirm Order" button
    Then They see an error message indicating that the order does not exist



