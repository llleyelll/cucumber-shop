Feature: Check inventory
    As an admin
    I want to check quantity of products

Background:
    Given 10 of product Bread with price 20.50 exists
    And 7 of product Jam with price 80.00 exists

Scenario: Sell one product
    When I sell Bread with quantity 2
    Then The quantity of Bread product should be 8

#Scenario: Buy multiple products
#    When I buy Bread with quantity 2
#    And I buy Jam with quantity 1
#    Then total should be 121.00