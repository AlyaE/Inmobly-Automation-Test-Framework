@launchDashboard @test
Feature: Dashboard Content Menu Section Tests

  @list1
  Scenario: Create New List with a Category Rule
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Lists" page
    And I add a new list named "my list"
    And I add a new rule by Category:
      | Fields    | Values   |
      | Filter    | Category |
      | Category  | site     |
      | SortBy    | Views    |
      | Order     |        1 |
      | Direction | Desc     |
      | MinYear   |     2001 |
      | Count     |        2 |
    Then I validate that the list name is "my list"
    And I validate that a rule is added by category:
      | Fields    | Values   |
      | Filter    | Category |
      | Category  | site     |
      | SortBy    | Views    |
      | Order     |        1 |
      | Direction | Desc     |
      | MinYear   |     2001 |
      | Count     |        2 |

  @list1
  Scenario: Create New List with a Tag Rule
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Lists" page
    And I add a new list named "my list"
    And I add a new rule by Tag:
      | Fields    | Values |
      | Filter    | Tag    |
      | Tag       | sales  |
      | SortBy    | Views  |
      | Order     |      1 |
      | Direction | Desc   |
      | MinYear   |   2001 |
      | Count     |      2 |
    Then I validate that the list name is "my list"
    And I validate that a rule is added by tag:
      | Fields    | Values |
      | Filter    | Tag    |
      | Tag       | sales  |
      | SortBy    | Views  |
      | Order     |      1 |
      | Direction | Desc   |
      | MinYear   |   2001 |
      | Count     |      2 |

  @list1
  Scenario: Create New List with a Series Rule
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Lists" page
    And I add a new list named "my list"
    And I add a new rule by Series:
      | Fields | Values       |
      | Filter | Series       |
      | Series | Breaking bad |
      | Order  |            1 |
    Then I validate that the list name is "my list"
    And I validate that a rule is added by series:
      | Fields | Values       |
      | Filter | Series       |
      | Series | Breaking bad |
      | Order  |            1 |
      
   @list1
  Scenario: Create New List with a Video
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Lists" page
    And I add a new list named "my list"
    And I add a new video named "Once Upon a Time"


  @list3
  Scenario: Editing a Preset Lists Name
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Lists" page
    And I change the preset list named "trending" to the name "trending test name"

  #validates but only if you save the preset list new name first in previous step
  #Then I validate that the preset list name is "trending test name"
  
  @list4
  Scenario: Viewing a custom list
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Lists" page
    And I view a custom list named "Feature"

  @menu1
  Scenario: Create New Template Menu Item
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Menu" page
    And I add a new template menu item named "Menu Item 1" for the "Home" screen

  #validates but only if you save the template menu created above
  #Then I validate that the template menu item named "Hala Menu Item" for the "Hala Screen" screen exists
  
  @menu2
  Scenario: Create New Parent Template Menu Item
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Menu" page
    And I add a new parent template menu item named "Menu Item 1"
    And I edit a sub menu named "Sub Menu 1" for the "Kids Screen" screen to the parent template named "Menu Item 1"
    And I add a sub menu named "Sub Menu 2" for the "Kids Screen" screen to the parent template named "Menu Item 1"
    Then I validate that the parent template menu item named "Menu Item 1" exists

  @notification1
  Scenario: Create Text Notification
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Notification" page
    And I create a new text notification:
      | Fields      | Values                  |
      | Profile     | Music                   |
      | Title       | new content             |
      | Description | long description here   |
      | Link        | https://www.google.com/ |
    Then I validate that the text notification information is correct:
      | Fields      | Values                  |
      | Profile     | Music                   |
      | Title       | new content             |
      | Description | long description here   |
      | Link        | https://www.google.com/ |

  @series1
  Scenario: Create a New Series
    When I am logged in as "inmobly-admin" with the password "support123456"
    And I navigate to the "Series and Seasons" page
    And I add a new series
      | Fields            | Values                |
      | Title             | New Series            |
      | ShortDescription  | description goes here |
      | Description       | More description here |
      | Tags              | Comedy                |
    Then I validate that the series information is correct
      | Fields            | Values                |
      | Title             | New Series            |
      | ShortDescription  | description goes here |
      | Description       | More description here |
      | Tags              | Comedy                |
