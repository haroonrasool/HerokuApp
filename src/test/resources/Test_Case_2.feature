@scolling

Feature: Infinite Scroll on Menu

  Background:
    Given user is on homepage
    When user clicks on infinite scroll link

  Scenario:
    And user scrolls to the bottom of the page twice
    And user scrolls back to the top of the page
    Then user can assert "Infinite Scroll" text successfully
