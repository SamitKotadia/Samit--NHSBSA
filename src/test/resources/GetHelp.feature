Feature: Check what help you could get to pay for NHS costs
  As a person from Wales
  I need to know what help I can get with my NHS costs
  So that I can get the treatment I need

  @Regression
  Scenario: Age over 16
    Given I am on Base URL page
    When I Click on "Start Now" button
    And I select "Wales" in "I Live in country" page
    And I Click on "Next" button
    And I select "Yes" for "GP practice in Scotland or Wales"
    And I Click on "Next" button
    And I select "Wales" in "my dental practice in" page
    And I Click on "Next" button
    And I input my Birth date value as "01" day "01" month and "2000" year
    And I Click on "Next" button
    And I select "Yes" for "live with a partner"
    And I Click on "Next" button
    And I select "Yes" for "you or your partner claim any benefits or tax credits"
    And I Click on "Next" button
    And I select "Yes" for "you or your partner get paid Universal Credit"
    And I Click on "Next" button
    And I select "Yes" for "As part of your joint Universal Credit"
    And I Click on "Next" button
    And I select "Yes" for "you and your partner have a combined take-home pay"
    And I Click on "Next" button
    Then I should see "Done" text

  @Regression
  Scenario: Negative
    Given I am on Base URL page
    When I Click on "Start Now" button
    And I Click on "Next" button
    And I can see error massage "There is a problem"

  @Regression @test
  Scenario: Age under 16
    Given I am on Base URL page
    When I Click on "Start Now" button
    And I select "Wales" in "I Live in country" page
    And I Click on "Next" button
    And I select "Yes" for "GP practice in Scotland or Wales"
    And I Click on "Next" button
    And I select "Wales" in "my dental practice in" page
    And I Click on "Next" button
    And I input my Birth date value as "01" day "01" month and "2007" year
    And I Click on "Next" button
    Then I should see "Done" text






