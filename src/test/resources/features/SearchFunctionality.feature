Feature: Search Functionality

  @search @sanity @regression @tc01
  Scenario: Verify Search button available on home page
    When I open the Bunnings website home page
    And I verify home page
    Then I verify search box and button on it
    Then I close the page

  @search @sanity @regression @tc02
  Scenario Outline: Verify placeholder text in searchbox
    When I open the Bunnings website home page
    And I verify home page
    Then I verify placeholder text "<placeholderText>" present in searchbox
    Then I close the page


    Examples:
      | placeholderText                               |
      | Search our products, services & D.I.Y. Advice |

  @search @sanity @regression @tc03
  Scenario Outline: Verify the Search results are displayed should be relevant to input search keyword
    When I open the Bunnings website home page
    And I verify home page
    Then I enter the text"<inputSearchtext>" in searchBox
    And I click on SearchButton
    Then I verify the relevant results "<expectedSearch>" present on search page
    Then I verify the relevant search result "<expectedSearch>" page displayed
    Then I close the page

    Examples:
      | inputSearchtext | expectedSearch |
      | tools           | tools          |

  @search @sanity @regression @tc04
  Scenario Outline: Verify the Search results are displayed should be relevant to input search keyword
    When I open the Bunnings website home page
    And I verify home page
    Then I enter the text"<inputSearchtext>" in searchBox
    And I click on SearchButton
    Then I verify the relevant results "<expectedSearch>" present on search page
    Then I close the page
    Examples:
      | inputSearchtext | expectedSearch |
      | tools           | tools          |
      | Garden          | Garden         |
