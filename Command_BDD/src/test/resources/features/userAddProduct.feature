Feature: userAddProduct

  Scenario: User adds a product to the order
    Given The user is on a product page
    When They click the "Add to Order" button
    Then They see a confirmation that the product has been added to the order

  Scenario: User increases the quantity of a product already in the order
    Given The product is already in the order
    When The user clicks "Add to Order" for that product
    Then The quantity of the product in the order is increased by 1




