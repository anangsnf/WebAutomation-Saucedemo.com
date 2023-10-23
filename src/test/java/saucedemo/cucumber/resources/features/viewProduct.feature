Feature: View Saucedemo Products

  Scenario: View Product Details
    Given user already open saucedemo
    When user input valid username
    And user input valid password
    And user click login button
    Then user successfully logged in and redirected to products page
    When user click product title
    Then user successfully open product details