Feature: Booking registration

  Scenario: Booking registration via email/ password
    Given I register temporary email using my mail.ru "jane.doe2022@mail.ru" account
    Given I open Booking page
    When I click on Register button
    And I register with my temporary email and "Automation2022!" password
    And I open mail.ru
    And I log in with "jane.doe2022@mail.ru", "Automation2022!"
    And I open email with "One more click to confirm your account" subject
    And I confirm registration on Booking
    And I open Booking page
    And I login with confirmed temporary email and "Automation2022!" password
    And I open Account settings page
    And I open Personal details page
    Then I see Verified label near the email
