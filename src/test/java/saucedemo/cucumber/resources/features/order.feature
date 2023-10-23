Feature: Order Product

  Scenario: Finish Order Product
    Given user already open saucedemo
    When user input valid username
    And user input valid password
    And user click login button
    Then user successfully logged in and redirected to products page
    When user click add to cart
    Then the cart shows amount product badge
    When user click cart icon
    And user click checkout button
    And user input first name
    And user input last name
    And user input postal code
    And user click continue button
    And user click finish button
    Then user successfully order product