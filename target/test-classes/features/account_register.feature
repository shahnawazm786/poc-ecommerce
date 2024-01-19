@login
Feature: Login Functions
@register
  Scenario: Register Account
    Given open the application
    When click on account icon
    Then verify Sign In page
    When click on register link
    And feed the value
    When i click on register button
    Then verify user is registered
 @signin
 Scenario: Login Accounts
  	Given open the application
    When click on account icon
    Then verify Sign In page
    When I enter data in login and password text box
    Then I click on singin button
    And I verify the user is login successfully
  
 
