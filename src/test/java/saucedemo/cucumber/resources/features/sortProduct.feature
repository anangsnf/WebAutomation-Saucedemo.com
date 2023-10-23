Feature: Sort Product List

  Scenario: Sort Product By Price Low To High
    Given user already open saucedemo
    When user input valid username
    And user input valid password
    And user click login button
    Then user successfully logged in and redirected to products page
    When user click sort icon
    And user choose price low to high
    Then user successfully sort product by price low to high