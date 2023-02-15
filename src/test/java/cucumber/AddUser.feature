#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Add user in Admin panel
  I want to test Add user functionality

Background:
Given I landed on Add user page

  @tag1
  Scenario: Positive test cases to test Add user
    Given Enter name <name>, address <address>, phone no. <phoneno>, Select country, state, city and Enter email <email>
    When Click on Submit button
    Then User added successfully
    
     Examples: 
      | name  | address  | phoneno  | email             |
      | Nishu | Badarpur | 7827317222 | nishu@yopmail.com |
  
