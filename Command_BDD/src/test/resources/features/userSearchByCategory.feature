Feature: Search by Category

  Scenario: User searches for products by category
    Given The user is on the search page
    When The user selects a category from the category list
    Then The user sees a list of products in that category

  Scenario: User searches for products by non-existent category
    Given The user is on the search page
    When The user selects a non-existent category from the category list
    Then They see an error message indicating that the category does not exist





