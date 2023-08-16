Feature: Basic

  @GymSharkTestOne
  Scenario Outline: Add a random product from New Releases
    Given I go to "<type>" New Releases
    And I select a random item
    And I verify details on Product page
    And I select a random size
    When I add the item to the basket
    Then I verify item has been added successfully to Summary page
    And I close the summary
    And I expect the basket icon to display number "1"
    And I click on basket icon
    And I verify item has been added successfully to Summary page
    And I verify values on Full Bag page
    And I verify values on Checkout page

    Examples:
      | type        |
      | men       |
