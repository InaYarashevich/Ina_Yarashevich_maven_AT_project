Feature: Booking wishlist

  Scenario: Saving items to wishlist
    Given I register temporary email using my mail.ru "jane.doe2022@mail.ru" account
    Given I open Booking main page
    When I click on Sign in button
    And I sign in with "anthony.hermann@trashmail.fr" and "Automation2022!"
    And I fill "Madrid"  in the field
    And I select next month date from now as check in date
    And I select checkout date to stay for 5 days
    And I click on the Search button
    And I save the 1 item in the list to wishlist
    And I save the 24 item in the list to wishlist
    And I open wishlist
    Then I see the first saved item on the page
    Then I see the last saved item on the page