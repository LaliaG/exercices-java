Feature: Add Product

  Scenario: User adds a product to the order
    Given The user is on the product page
    When They click the "Add to Order" button to add product
    Then The product is added to their order


