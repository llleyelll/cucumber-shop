Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given 10 of product Bread with price 20.50 exists
    And 7 of product Jam with price 80.00 exists

Scenario: Buy one product
    When I buy Bread with quantity 2
    Then total should be 41.00
    And The quantity of Bread product should be 8

Scenario: Buy multiple products
    When I buy Bread with quantity 5
    And I buy Jam with quantity 1
    Then total should be 182.50
    And The quantity of Bread product should be 5
    And The quantity of Jam product should be 6

Scenario: Buy product out of stock
    When I buy Jam with quantity 11
    Then my order of 11 of Jam was cancelled