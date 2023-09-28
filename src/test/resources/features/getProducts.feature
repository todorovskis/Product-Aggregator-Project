Feature: Retrieving products

  Background:
    Given the application is running

  Scenario: Get a list of all products
    When the client calls endpoint for all products "/api/products"
    Then the response status code for all products should be 200
    And the response should contain a list of products

  Scenario: Get a single product by ID
    When the client calls endpoint for a single product "/api/products/{id}"
    Then the response status code for a single product should be 200
    And the response should contain a single product

  Scenario: Filter products by name
    When the client calls endpoint "/api/products/filter" with the following query parameters:
      | productName |
      | Galaxy A50  |
    Then the response status code should be 200
    And the response should contain a list of filtered products

  Scenario: Filter products by category
    When the client calls endpoint "/api/products/filter" with the following query parameters:
      | categoryId |
      | 1          |
    Then the response status code should be 200
    And the response should contain a list of filtered products

  Scenario: Filter products by manufacturer
    When the client calls endpoint "/api/products/filter" with the following query parameters:
      | manufacturerId |
      | 1              |
    Then the response status code should be 200
    And the response should contain a list of filtered products

  Scenario: Filter products by multiple criteria
    When the client calls endpoint "/api/products/filter" with the following query parameters:
      | productName | categoryId | manufacturerId |
      | Galaxy A50  | 1          | 1              |
    Then the response status code should be 200
    And the response should contain a list of filtered products