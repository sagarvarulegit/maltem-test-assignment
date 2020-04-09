Feature: Scenarios to test example mentioned in Chapter 4
  Background: I have opened webpage
    Given I have open the automated tester website

  Scenario: Verify alert box shows entered text
    Given I am on chapter four assignment page
    When I enter 'abc123' in text box
    Then Verify alert box also has text 'abc123'

    @wip
  Scenario: Verify Select box has mentioned values
    Given I am on chapter four assignment page
    Then Verify Select box also has values 'Selenium IDE, Selenium Core, Selenium RC, Selenium Grid'
