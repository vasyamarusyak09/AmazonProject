@SmokeTest
Feature: Verify Customer Page functionality

  Scenario: Validate Title
    Given User is on the Home page
    When User click on Customer Service link
    Then User is redirected to the Customer Service page