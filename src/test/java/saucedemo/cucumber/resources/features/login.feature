Feature: Log In To Sausdemo Website

  Scenario: Success Login
    Given user already open saucedemo
    When user input valid username
    And user input valid password
    And user click login button
    Then user successfully logged in and redirected to products page

  Scenario: Failed Login
    Given user already open saucedemo
    When user input valid username
    And user input invalid password
    And user click login button
    Then user failed to log in and get error message