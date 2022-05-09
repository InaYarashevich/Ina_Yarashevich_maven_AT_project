Feature: My first demo feature

  Scenario: My first demo test
    Given I open test site
    When I fill "Париж" into form
    Then I see greeting message


  Scenario: My second demo test
    Given I open test site
    When I fill "Лондон" into form
    Then I see greeting message


  Scenario: My third demo test
    Given I open test site
    When I fill "Барселона" into form
    Then I see greeting message