
Narrative:
As a user
I want to have a possibility to add any online product to the cart
So that I can proceed with purchasing the product


Lifecycle:
Before:
Given a step that is executed before each scenario
After:
Given a step that is executed after each scenario

Scenario: User adds product to the Cart from PDP
Given User opens <homepage> page
And User clicks on <gender> category
And User hovers on <category> category from the navigation
And User clicks on <subcategory> subcategory from the dropdown
And User is redirected to the Product Listing page
And User clicks on the <product_id> product tile
And Product Details Page is opened
When User selects <size> size
And User clicks on Add to Cart button
Then Mini Cart pop-up is displayed
And the product with <size> and <variant_id> is added to the Cart

Examples:
|homepage             |gender|category|subcategory|product_id|size   |variant_id|
|https://www.asos.com/|men   |Shoes   |Boots      |200511928 |EU 44  |200511933 |

Scenario: User move product to the Cart from the Wishlist
Given User opens <homepage> page
And User clicks on <gender> category
And User hovers on <category> category from the navigation
And User clicks on <subcategory> subcategory from the dropdown
And User is redirected to the Product Listing page
And User clicks on the <product_id> product tile
And Product Details Page is opened
When User adds product to the Wishlist
And User clicks on Wishlist icon
And Wishlist page is opened
And User selects <size> size for product tile
And User clicks Move to Bag button
Then Mini Cart pop-up is displayed
And the product with <size> and <variant_id> is added to the Cart

Examples:
|homepage             |gender|category|subcategory|product_id|size   |variant_id|
|https://www.asos.com/|men   |Shoes   |Boots      |200511928 |EU 44  |200511933 |

Scenario: User clicks Add to Cart button without selecting a size
Given User opens <homepage> page
And User clicks on <gender> category
And User hovers on <category> category from the navigation
And User clicks on <subcategory> subcategory from the dropdown
And User is redirected to the Product Listing page
And User clicks on the <product_id> product tile
And Product Details Page is opened
When User clicks on Add to Cart button
Then error message is displayed
And error message text is '<error_message_text>'
Examples:
|homepage             |gender|category|subcategory|product_id|error_message_text                                      |
|https://www.asos.com/|men   |Clothing|Jeans      |22624988  |Please select from the available colour and size options|