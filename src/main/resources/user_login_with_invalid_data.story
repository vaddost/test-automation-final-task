Narrative:
As a user
I want to be prevented from login with incorrect details
so that I can be informed about my invalid actions

Lifecycle:
Before:
Given a step that is executed before each scenario
After:
Given a step that is executed after each scenario

Scenario: User signs in with incorrect data
Given User opens <homepage> page
And User clicks on My Account icon
And User clicks on Sign in link
And User is redirected on Sign in page
When User enters <email> email address
And User enters <password> password
And User clicks Sign in button
Then User is redirected on Sign in page
And The error message indicated about not successful login with <error_text> text is present
Examples:
|homepage             |email              |password|error_text                                                                       |
|https://www.asos.com/|test_test@gmail.com|12345   |Looks like either your email address or password were incorrect. Wanna try again?|

Scenario: User signs in with invalid email
Given User opens <homepage> page
And User clicks on My Account icon
And User clicks on Sign in link
And User is redirected on Sign in page
When User enters <email> email address
Then The email field validation error message with <email_error_text> text is displayed

Examples:
|homepage             |email                        |email_error_text                                     |
|https://www.asos.com/|plainaddress                 |Email fail! Please type in your correct email address|

Scenario: User signs in without password
Given User opens <homepage> page
And User clicks on My Account icon
And User clicks on Sign in link
And User is redirected on Sign in page
When User enters <email> email address
And User clicks Sign in button
Then the password field validation message with <password_error_text> text is displayed

Examples:
|homepage             |email         |password_error_text         |                                                                |
|https://www.asos.com/|test@gmail.com|Hey, we need a password here|

Scenario: User signs in without email address
Given User opens <homepage> page
And User clicks on My Account icon
And User clicks on Sign in link
And User is redirected on Sign in page
When User enters <password> password
And User clicks Sign in button
Then The email field validation error message with <email_error_text> text is displayed

Examples:
|homepage             |password              |email_error_text                      |
|https://www.asos.com/|12345                 |Oops! You need to type your email here|