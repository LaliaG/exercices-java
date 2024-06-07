Feature: User places an order

  Scenario: Successful order placement
    Given The user has products in their order
    When They click the "Order" button
    Then They see the order form
    When They fill in the required information
    And They click the "Confirm Order" button
    Then They receive an order confirmation

  Scenario: Confirm non-existent order
    Given The user tries to confirm a non-existent order
    When They click the "Confirm Order" button
    Then They see an error message indicating that the order does not exist



