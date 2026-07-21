# Feature files describe behaviour in plain English (Gherkin syntax).
# Each Scenario maps to a test case; tags like @P1 / @P2 let you run subsets.
# Run only @P2: mvn test -Dtest=TestRunner -Dcucumber.filter.tags=@P2

Feature: First Feature

  @P1
  Scenario: Simple Test

    Given I have numbers
    When I add them
    Then I get the sum

  # P2 scenario demonstrates the same flow – previously incomplete (missing When/Then)
  @P2
  Scenario: Simple Test P2

    Given I have numbers
    When I add them
    Then I get the sum
