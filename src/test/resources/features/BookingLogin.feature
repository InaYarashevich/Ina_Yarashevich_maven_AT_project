Feature: Booking login

  Scenario: Booking login with Email and Password
    Given I open Booking main page

    Then I see following elements:
      | BOOKING_LOGO            |
      | CURRENCY                |
      | LANGUAGE                |
      | PROFILE_MENU            |
      | CUSTOMER_SERVICE        |
      | NOTIFICATIONS_BELL_ICON |
      | YOUR_PROPERTY_ICON      |
      | HEADER_NAVIGATION       |

