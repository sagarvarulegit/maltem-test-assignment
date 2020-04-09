Feature: Scenarios to test example mentioned in Chapter 2

  Background: I have opened webpage
    Given I have open the automated tester website

  Scenario Outline: Verify all buttons are present
    Given I am on chapter two assignment page
    Then Verify following elements with attribute "<attribute>" and "<value>" are present
    Examples:
      | attribute | value                                                                   |
      | value     | chocolate                                                               |
      | name      | verifybutton                                                            |
      | id        | but1                                                                    |
      | xpath     | .//input[@id='but1']//following-sibling::input[@value='Sibling Button'] |
