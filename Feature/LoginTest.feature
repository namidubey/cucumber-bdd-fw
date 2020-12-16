Feature: Login Scenarios for Gmail

  Scenario: Successful Login with Valid Credentials
    Given User is on Home Page
    When User enters UserName and Password
    Then Login is successful
    Then Application should be closed

  Scenario: No login due to invalid Credentials
    Given User is on Home Page
    When User enters incorrect UserName and Password
    Then Error Message Displayed
    Then Application should be closed

  Scenario: No login due to none Credentials
    Given User is on Home Page
    When User enters blank UserName and Password
    Then Error Message For Blank Displayed
    Then Application should be closed
