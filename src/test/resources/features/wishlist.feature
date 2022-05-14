Feature: Booking wishlist

  Scenario: Saving items to wishlist
    Given I open Booking main page
    When I click on Sign in button
    And I input email
    And I click on submit button
    And I input password
    And I click on SignIn
    And I fill "Madrid"  in the field
    And I select check in date
    And I select checkout date
    And I select the number of the adults
    And I select the number of the rooms
    And I click on the Search button