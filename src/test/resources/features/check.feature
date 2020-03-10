Feature: Check inventory
    As an admin
    I want to check quantity of products

Background:
    Given 10 of product Bread with price 20.50 exists
    And 7 of product Jam with price 80.00 exists

Scenario: Sell one product
    When I sell Bread with quantity 2
    Then The quantity of Bread product should be 8

Scenario: Sell multiple products
    When I sell Bread with quantity 5
    And I sell Jam with quantity 1
    Then The quantity of Bread product should be 5
    And The quantity of Jam product should be 6