Feature: Booking registration

  Scenario: Booking registration via email/ password
    Given I open Booking main page
    When I click on Register button
    And I input Email address
    And I click on Continue with email
    And I input Password
    And I confirm Password
    And I click on Create Account
    Then I see the 'Welcome to Booking.com!' greeting modal