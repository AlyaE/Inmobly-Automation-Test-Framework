@launchDashboard @test
Feature: Sample Test

  @test1
  Scenario: Logging in with set credentials
    When I am logged in as "inmobly-admin" with the password "support123456"
    Then I validate the login attempt
  
  @test1
  Scenario: Logging in with set credentials 2
    When I am logged in as "inmobly-admin" with the password "support123456"
    Then I validate the login attempt