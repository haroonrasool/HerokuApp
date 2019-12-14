@keypresses

Feature: Key presses on Menu

  Background:
    Given user is on homepage

  Scenario:
    When user clicks on key presses link
    And user clicks on four keys
    Then user asserts the text displayed after every key is pressed
