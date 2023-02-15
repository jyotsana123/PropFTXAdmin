@tag
Feature: Login in Admin panel
  I want to test login functionality

Background:
Given I landed on Admin login page

  @tag1
  Scenario Outline: Positive test case for Login functionality
    Given Logged in with valid email <Email> and valid password <Password>
    When Click on login button
    Then Dashboard should be displayed

    Examples: 
      | Email                           | Password  | 
      | jyotsana.pandey@mail.vinove.com | Admin@123 |
      
      
 @tag2
  Scenario Outline: Negative test case for Login functionality
    Given Logged in with wrong email <Email> and wrong password <Password>
    When Click on login button
    Then Error message should be displayed

    Examples: 
      | Email                    | Password   | 
      | jyotsana@mail.vinove.com | Admin@1234 |
      
      
 @tag3
  Scenario Outline: Negative test case for Login functionality
    #Given Logged in with without email <Email> and without password <Password>
    When Click on login button
    Then Error message should be displayed for email and password

      
 @tag4
  Scenario Outline: Negative test case for Login functionality
    Given Logged in with invalid email <Email> and valid password <Password>
    When Click on login button
    Then Error message should be displayed for email
    
    Examples: 
      | Email    | Password  | 
      | jyotsana | Admin@123 |
      
 
  @tag5
  Scenario Outline: Show password on login page
    Given Enter email <Email> and password <Password>
    When Click on password eye icon
    Then Password should be displayed <Password>

    Examples: 
      | Email                           | Password  | 
      | jyotsana.pandey@mail.vinove.com | Admin@123 |      
      
      
 @tag6
  Scenario Outline: Positive test case for Forgot password functionality
    Given Enter email on forgot password page <Email>
    When Click on submit button
    Then Reset link sent message should be displayed

    Examples: 
      | Email                           | 
      | jyotsana.pandey@mail.vinove.com |    
      
 @tag7
  Scenario Outline: Negative test case for Forgot password functionality
    Given I am on forgot password page
    When Click on submit button1
    Then Error should be displayed for email 
    
 @tag8
  Scenario Outline: Negative test case for Forgot password functionality
    Given Enter invalid email on forgot password page <Email>
    When Click on submit button2
    Then Error message should be displayed for invalid email

    Examples: 
      | Email    | 
      | jyotsana |    
      
 @tag9
  Scenario Outline: Negative test case for Forgot password functionality
    Given Enter non existing email on forgot password page <Email>
    When Click on submit button3
    Then Error message should be displayed for non existing email

    Examples: 
      | Email                    | 
      | jyotsana@mail.vinove.com |               