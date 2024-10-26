Feature: sample
  @Mahesh
  Scenario: To verify the input json data added to the table
    Given User navigate to the html table page
    When User click on the Table Data button
    And User insert the data into the input box
    And User click on the Refresh Table button
    Then User Verify the table should display the inserted data
