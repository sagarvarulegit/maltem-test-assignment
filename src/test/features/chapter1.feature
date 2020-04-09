Feature: Scenarios to test example mentioned in Chapter 1
  Background: I have opened webpage
    Given I have open the automated tester website

  Scenario Outline: Verify Chapters are present
    Then Verify following chapters "<chapters>" are present
    Examples:
    |chapters|
    |Chapter1|
    |Chapter2|
    |Chapter3|
    |Chapter4|
    |Chapter8|

  Scenario: Assert that this text is on the page
    Given I am on chapter one assignment page
    Then Verify 'Assert that this text is on the page' is present

  Scenario: Click on the links which launches multiple window
     Given I am on chapter one assignment page
     When I click on link to launch another window
     Then Verify 'Text within the pop up window' is present in new windows

  Scenario: Click on the links to load page with AJAX
    Given I am on chapter one assignment page
    When I click on AJAX link to load page
    Then Verify 'The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter' is present in new AJAX box

  Scenario: Verify Button is present
    Given I am on chapter one assignment page
    Then Verify button is present
