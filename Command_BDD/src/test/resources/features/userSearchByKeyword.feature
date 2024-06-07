Feature: Search by Keyword

  Scenario: User searches for products by keyword
    Given The user is on the search page
    When The user enters a keyword in the search bar
    And clicks the "Search" button
    Then The user sees a list of products matching the keyword

  Scenario: User searches for products with a non-existent keyword
    Given The user is on the search page
    When The user enters a non-existent keyword in the search bar
    And clicks the "Search" button
    Then They see an error message indicating that no products match the keyword
