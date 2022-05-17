Feature: Booking registration

  Scenario: Booking registration via email/ password
    Given I open Booking main page
    When I click on Register button
    And I register with "email" and "password"
    Then I see the 'Welcome to Booking.com!' greeting modal