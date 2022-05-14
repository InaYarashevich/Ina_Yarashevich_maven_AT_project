Feature: Hotels results list

  Scenario: Hotels results list is not empty
    Given I open Booking main page
    When I fill "Лондон"  in the field
    And I select check in date
    And I select checkout date
    And I click on the Search button
    Then I see the list of the hotels