Feature: main page
  @header
  Scenario: test main page has logo
    Given open main page
    When find logo on main page
    Then main page has logo

  @header
  Scenario: test main page has signIn and signUp modal window
    Given open main page
    When click on auth button
    Then opened signIn and signUp modal window

  @footer
  Scenario: test main page email subscribe
    Given open main page
    When input email for subscribe
    When click on subscribe button
    Then view text success subscribe

  @footer
  Scenario: test main page has social icon
    Given open main page
    Then check facebook social icon
    And check vkontakte social icon
    And check Zen social icon
    And check OK social icon
    And check youtube social icon

  @support
  Scenario: test main page has support widget
    Given open main page
    When click on support widget button
    Then opened support widget modal

  @header
  Scenario: test main page notifications
    Given open main page
    When cursor move to notification icon
    Then opened notifications dropdown