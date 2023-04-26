@allrun
Feature: Login Functionality

Background:
Given user should be on login page

@test
Scenario: valid login

When user enters valid username and password
And  clicks on login button
Then user should be navigated to home page
And user can see friends logo on home page
And close browser

@test
Scenario: Invalid login

When user enters valid username and Invalid password
And  clicks on login button
Then user should be navigated to login page
And user can see error message
And close browser

