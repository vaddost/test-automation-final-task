Narrative:
As a user
I want to be able search for a product
So that I can find the product to buy

Lifecycle:
Before:
Given a step that is executed before each scenario
After:
Given a step that is executed after each scenario


Scenario: User checks page components on Search Results page
Given User opens <homepage> page
When User enters <search_phrase> in the search field
And User clicks on Search button
Then The Search Results Page is opened
And page URL contains <search_query>
And search term banner contains <search_phrase>
And product count is displayed
And Filters section is displayed
And Product Grid is not empty
And progress bar is displayed

Examples:
| homepage              | search_phrase | search_query |
| https://www.asos.com/ | shoes         | q=shoes      |

Scenario: User filters search results by brand
Given User opens <homepage> page
When User enters <search_phrase> in the search field
And User clicks on Search button
And The Search Results Page is opened
And User filters products by <brand> brand
Then The <brand> brand filter is selected
And products are filtered by <brand> brand

Examples:
| homepage              | search_phrase | brand   |
| https://www.asos.com/ | shoes         | Grenson |

Scenario: User clicks on product
Given User opens <homepage> page
When User enters <search_phrase> in the search field
And User clicks on Search button
And The Search Results Page is opened
And User clicks on the first product on the page
Then Product Details Page is opened

Examples:
| homepage              | search_phrase |
| https://www.asos.com/ | shoes         |