Feature: Example Feature

  Scenario: Perform a GET request
    Given the base URL is "https://www.boredapi.com/api"
    When a GET request is made to "/activity"
    Then the response status code should be 200
