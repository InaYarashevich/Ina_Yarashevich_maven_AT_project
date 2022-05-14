Feature: Booking login

  Scenario: Booking login with email/ password
    Given I open Booking main page
    When I click on Sign in button
    And I input email
    And I click on submit button
    And I input password
    And I click on SignIn
    Then The Booking logo element is displayed
    Then Language icon is displayed
    Then Currency icon is displayed
    Then Customer service icon is displayed
    Then Notifications bell icon is displayed
    Then Property icon is displayed
    Then Profile menu button is displayed
    Then Header navigation is displayed