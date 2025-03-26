Feature: User Authentication on Demo Web Shop

Background:
  Given User is on the website

Scenario: Register a new user with valid details
  When User navigates to the registration page
  And User enters valid registration details
  And Clicks on the register button
  Then Registration should be successful
  And User should be able to log in with the registered credentials

Scenario: Register a user with an already existing email
  When User navigates to the registration page
  And User enters an already registered email
  And Clicks on the register button
  Then An error message should be displayed indicating email already exists
  And User should log in with the required credentials for confirming

Scenario: Login with valid credentials
  When User navigates to the login page
  And User enters valid credentials
  And Clicks on the login button
  Then User should be logged in successfully
  And Logout button should be visible

Scenario: Login with invalid credentials
  When User navigates to the login page
  And User enters invalid credentials
  And Clicks on the login button
  Then An error message should be displayed indicating invalid login

Scenario: Product Search and Add to Cart
Given User is on the homepage
When User searches for "14.1-inch Laptop"
And Clicks on the product from the search results
And Clicks on the Add to Cart button
Then The product should be added to the cart successfully

Scenario: Adding Multiple Products to Cart & Validating Cart Summary
  Given User is on the WebHomepage
  When User search for "Computing and Internet"
  And Clicks on the product from the search result
  And Clicks on the Add to Cart button for first result
  And User search for "Smartphone"
  And Clicks on the product from the search result
  And Clicks on the Add to Cart button for second result
  And User navigates to the cart page
  Then The cart should display both products
  And The total price should be displayed
  
Scenario: Applying a coupon code
  Given User has added a product to the cart
  When User navigates to the checkout page
  And User enters a coupon code
  Then The coupon code should be validated correctly
  
Scenario: Checkout Process with Invalid Data Handling
  Given User open the shopping cart
  When User clicks on checkout button
  And User enters invalid shipping details
  Then An error message should be displayed
  When User enters valid shipping details
  And Completes the checkout process
  Then An order confirmation message should be displayed  


Scenario: Logout from the website
  Given User is logged in
  When User clicks on the logout button
  Then Login button should be visible