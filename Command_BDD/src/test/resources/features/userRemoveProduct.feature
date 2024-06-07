Feature: User removes products from order

  Scenario: Remove product from order
    Given The product is in the order
    When The user clicks the "Remove from Order" button for that product
    Then The quantity of the product in the order is decreased by 1

  Scenario: Remove non-existent product from order
    Given The product is not in the order
    When The user clicks the "Remove from Order" button for that product
    Then They see an error message indicating that the product is not in the order


