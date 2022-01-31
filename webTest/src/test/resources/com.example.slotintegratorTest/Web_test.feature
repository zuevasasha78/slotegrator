Feature: Web test

  Scenario: Check players sorted
    Given Open login page
    When Login "admin1" , "[9k<k8^z!+$$GkuP"
    And Check page is loading
    And Open players list
    And Check players table displayed
    And Sorted players by registration date
    Then Check sorted players