Feature: Hotels Filtering

  Scenario: Filtering hotels by max price per night
    Given I open Booking main page
    When I fill "Париж"  in the field
    And I select check in date
    And I select checkout date to stay for 5 days
    And I select the number of the adults
    And I select the number of the rooms
    And I click on the Search button
    And I filter the list of the found hotels by the max price per night
    And I sort the list of the results by the lowest price
    Then I see the list of the hotels with max price per night

  Scenario: Getting hotels search results
    Given I open Booking main page
    When I fill "Лондон"  in the field
    And I select check in date
    And I select checkout date to stay for 5 days
    And I click on the Search button
    Then I see the list of the hotels

    Scenario: Filtering hotels by max rating
      Given I open Booking main page
      When I fill "Madrid"  in the field
      And I click on the Search button
      And I filter hotels by "SUPERB" rating
      And I open detailed page of the 1-st hotel
      Then I see hotel with selected rating


