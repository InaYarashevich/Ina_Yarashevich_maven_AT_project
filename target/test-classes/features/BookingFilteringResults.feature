Feature: Hotels filtering by max price per night

  Scenario: Booking hotel price per night
    Given I open Booking main page
    When I fill "Париж"  in the field
    And I select check in date
    And I select checkout date
    And I select the number of the adults
    And I select the number of the rooms
    And I click on the Search button
    And I filter the list of the found hotels by the max price per night
    And I sort the list of the results by the lowest price
    Then I see the list of the hotels with max price per night

Feature: Hotels results list

  Scenario: Hotels results list is not empty
    Given I open Booking main page
    When I fill "Лондон"  in the field
    And I select check in date
    And I select checkout date
    And I click on the Search button
    Then I see the list of the hotels