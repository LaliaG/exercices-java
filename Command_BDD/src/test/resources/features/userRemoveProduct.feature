Feature: Removing Products from Order

  Scenario: User decreases the quantity of a product in the order
    Given The product is in the order
    When The user clicks the "Remove" button for that product
    Then The quantity of the product in the order is decreased by 1

  Scenario: Error if the product is not in the order
    Given The product is not in the order
    When The user clicks the "Remove" button for that product
    Then They see an error message indicating that the product is not in the order


