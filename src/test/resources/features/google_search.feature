@Smoke
Feature: Google Search

  @ValidateGoogleTitle @mobile
  Scenario: Search for Automation on Google
    Given I am on the Google search page
    When I type the search term from json
    Then I should see results related to Automation

  @ValidateGoogleTitle @desktop
  Scenario: Search for Automation on Google
    Given I am on the Google search page
    When I type the search term from json
    Then I should see results related to Automation

  @ValidateGoogleTitle @desktop
  Scenario: Search for Automation on Google
    Given I am on the Google search page
    When I type the search term from json
    Then I should see results related to Automation
    @ValidateGoogleTitle @mobile