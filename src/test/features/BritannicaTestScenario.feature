Feature: This is a feature file

  Background:
    Given I open shufersal home page

  Scenario: Britannica Test Scenario
    Given I login to shufersal website with username "email@something.com" and password "123456"
    And I search product name "חלב"
    And I filter the results by price from low to high
    When I add product to cart with keyword "חלב"
    And I calculate the total price in cart with delivery fee
    Then I check total price in cart if equals calculated price