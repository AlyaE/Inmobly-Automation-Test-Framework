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
@launchDashboard @test
Feature: Dashboard Content Menu Section Tests

  @list1
  Scenario: Create New List with a Category Rule
    When I am logged in as "username" with the password "password"
    And I navigate to the "Lists" page
    And I add a new list named "my list"
    And I add a new rule
    | Filter	 | Filter 2 | Order | Sort By | Direction | Min Year | Count |
    | Category | site			|  1		| views   | Asc				| 2001     |  1    |
    
    Then I validate that the list name is "my list"
    And I validate that the rule is added
    | Filter	 | Filter 2 | Order | Sort By | Direction | Min Year | Count |
    | Category | site			|  1		| views   | Asc				| 2001     |  1    |
    
  @list2
  Scenario: Create New List with a Video
    When I am logged in as "username" with the password "password"
    And I navigate to the "Lists" page
    And I add a new list named "my list"
    And I search and add a new video
    | Filter	 | Filter 2 | Keywords	 | Video Name			  |
    | All			 | All			|  Once		   | Once Upon a Time |
    
    Then I validate that the list name is "my list"
    And I validate that the video named "Once Upon a Time" was added
    
  @list3
  Scenario: Editing a Preset List
    When I am logged in as "username" with the password "password"
    And I navigate to the "Lists" page
    And I change the preset list named "trending" to the name "trending test name"
    Then I validate that the list name is "trending test name"
    
  @list4
  Scenario: Editing a Custom List, Change Video Order
    When I am logged in as "username" with the password "password"
    And I navigate to the "Lists" page
    And I change the preset list named "trending" to the name "trending test name"
    And I move the video named "Mad Max" to order number "5"
    Then I validate that the video named "Mad Max" is at position "5"
    
  @list5
  Scenario: Editing a Custom List, Adding a Video
    When I am logged in as "username" with the password "password"
    And I navigate to the "Lists" page
    And I view the custom list named "Feature"
    And I search and add a new video
    | Filter	 | Filter 2 | Keywords	 | Video Name			  |
    | All			 | All			|  Once		   | Once Upon a Time |
    
    Then I validate that the list name is "my list"
    And I validate that the video named "Once Upon a Time" was added 
    
  @series1
  Scenario: Create a New Series
    When I am logged in as "username" with the password "password"
    And I navigate to the "Series and Seasons" page
    And I add a new series
    | Title			 | Short Description		 | Description					  | Tags   |
    | New Series | description goes here |  More description here | Comedy |
    
    Then I validate that the series information is correct
    | Title			 | Short Description		 | Description					  | Tags   |
    | New Series | description goes here |  More description here | Comedy |
    
  @menu1
  Scenario: Create New Template Menu Item
    When I am logged in as "username" with the password "password"
    And I navigate to the "Menu" page
    And I add a new template menu item named "Menu Item 1" for the "Home" screen
    Then I validate that the template menu item named "Menu Item 1" for the "Home" screen exists

  @menu2
  Scenario: Create New Parent Template Menu Item
    When I am logged in as "username" with the password "password"
    And I navigate to the "Menu" page
    And I add a new parent template menu item named "Menu Item 1" 
    And I add a sub menu named "Sub Menu 1" for the "Kids Screen" screen to the parent template named "Menu Item 1"
    Then I validate that the parent template menu item named "Menu Item 1" exists
    And I validate that the parent template has a sub menu named "Sub Menu 1" for the "Kids Screen" screen
    
  @notification1
  Scenario: Create Text Notification
    When I am logged in as "username" with the password "password"
    And I navigate to the "Notification" page
    And I create a new text notification
    | Profile		   | Title		   | Description					  | Link  								  |
    | All Profiles | new content |  long description here | https://www.google.com/ |
    
    Then I validate that the text notification information is correct
    | Profile		   | Title		   | Description					  | Link  								  |
    | All Profiles | new content |  long description here | https://www.google.com/ |
    
  @notification2
  Scenario: Create Video Notification
    When I am logged in as "username" with the password "password"
    And I navigate to the "Notification" page
    And I create a new video notification
    | Profile		   | Title		   | Description					  | Video name			 |
    | All Profiles | new content |  long description here | Once Upon a Time |
    
    Then I validate that the video notification information is correct
    | Profile		   | Title		   | Description					  | Video Name			 |
    | All Profiles | new content |  long description here | Once Upon a Time |
    
  @screen1
  Scenario: Find and Edit a Screens Row Theme
    When I am logged in as "username" with the password "password"
    And I navigate to the "Screens" page
    And I view the screen named "TEST"
    And I view the row named "For you"
    And I change the theme "Theme no. 1" style to "Shelf wide"
 #   And I change the theme "Theme no. 1" filter  <--------- find a way to add multiple inputs or just one
 	  And I change the theme "Theme no. 1" list "Recomendados" start date to "2019-03-09" and end date to "2019-06-14"
 	  #Then some validation for the different fields
 	 
 	@screen2
  Scenario: Create a new Screen
    When I am logged in as "username" with the password "password"
    And I navigate to the "Screens" page
    And I create a new screen named "My Screen Test"
    And I add a new row named "For you"  #find a way to get the desired details
 	  #Then some validation for the different fields
 	 

