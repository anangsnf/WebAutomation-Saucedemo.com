Feature: Shopping Cart

  Scenario: Add Product To Cart
    Given user already open saucedemo
    When user input valid username
    And user input valid password
    And user click login button
    Then user successfully logged in and redirected to products page
    When user click add to cart
    Then the cart shows amount product badge