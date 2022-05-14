Feature: Booking wishlist

  Scenario: Saving items to wishlist
    Given I open Booking main page
    When I click on Sign in button
    And I input email
    And I click on submit button
    And I input password
    And I click on SignIn
    And Homepage is opened
    And I fill "Madrid"  in the field
    And I select check in date
    And I select checkout date
    And I click on the Search button
    And I save the first item in the list to wishlist
    And I save the last item in the list to wishlist
    And I open wishlist
    Then I see the first saved item on the page
    Then I see the last saved item on the page
