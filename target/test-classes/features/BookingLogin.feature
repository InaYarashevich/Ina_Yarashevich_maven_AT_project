Feature: Booking login

  Scenario: Booking login with Email and Password
    Given I open Booking main page
    When I click on Sign in button
    And I sign in with "renee.brakus@trashmail.fr" and "Automation2022!"
    Then I see "BOOKING_LOGO" element

  Scenario: Booking login with Email and Password
    Given I open Booking main page
    When I click on Sign in button
    And I sign in with "renee.brakus@trashmail.fr" and "Automation2022!"
    Then I see "CURRENCY" element

  Scenario: Booking login with Email and Password
    Given I open Booking main page
    When I click on Sign in button
    And I sign in with "renee.brakus@trashmail.fr" and "Automation2022!"
    Then I see "PROFILE_MENU" element