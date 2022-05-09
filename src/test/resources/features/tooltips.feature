Feature: Tooltips on hover

  Scenario: Currency tooltip text
    Given I open Booking page
    When I hover on currency icon
    Then I see the currency element tooltip appears

  Scenario: Language tooltip text
    Given I open Booking page
    When I hover on language icon
    Then I see the language element tooltip appears