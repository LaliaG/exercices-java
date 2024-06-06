Feature: Product Search

  Scenario: User accesses a search bar
    Given The user is on the homepage
    Then They see a search bar

  Scenario: User performs a search and sees relevant results
    Given The user is on the homepage
    When They enter a keyword in the search bar
    And They click the search button
    Then They see a list of relevant search results


