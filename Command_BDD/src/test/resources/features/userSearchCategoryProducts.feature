Feature: Product Category Navigation

  Scenario: User accesses a categories page
    Given The user is on the homepage
    When They click on the "Categories" link
    Then They see a page listing product categories

  Scenario: User clicks on a category and sees corresponding products
    Given The user is on the categories page
    When They click on a category
    Then They see a list of products corresponding to that category



