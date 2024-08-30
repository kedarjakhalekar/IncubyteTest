#Author
#Date
#Description
Feature: feature to test Create Account functionality

  Scenario: Check login is successful with valid credentials
    Given Browser is open 
    And user is on Create Account  page
    When user enteres username and password
    And clicks on submit button
    Then account is created
