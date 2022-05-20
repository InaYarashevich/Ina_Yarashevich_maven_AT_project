Feature: Booking registration

  Scenario: Booking registration via email/ password
    Given I register temporary email using my mail.ru "jane.doe2022@mail.ru" account
    Given I open Booking page
    When I click on Register button
    And I register with my "anthony.hermann@trashmail.fr" and "Automation2022!" password
    And I log in to mail.ru ("jane.doe2022@mail.ru", "Automation2022!") and confirm registration in "One more click to confirm your account" email
    And I login with confirmed "anthony.hermann@trashmail.fr" and "Automation2022!"
    And I open Account settings page
    And I open Personal details page
    Then I see Verified label near the email
