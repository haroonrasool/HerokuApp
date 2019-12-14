@login

Feature: Automate Form Authentication on Menu

  Background:
    Given user is on homepage
    And user clicks on form authentication link

  Scenario:
    When user enters correct username and wrong password
    Then user fails to login

  Scenario:
    When user enters wrong username and correct password
    Then user fails to login

  Scenario:
    When user enters correct username and correct password
    And user logs in successfully
    Then user can log out successfully
