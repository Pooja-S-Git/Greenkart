Feature: To check the functionality of placing order and navigate back to home page.
Scenario: Check user is able to proceed with place order and back to home page

Given User able to open URL and view the home page
When User able to select multiple products and add to the cart
And Click cart icon in homepage application
And User able to remove 3rd and 6th item of cart
And Click proceed to checkout button
And Click the place order button
And User able to choose country,accept check box and click on proceed
And User able to view thankyou page after clicking placing order 
Then Click on homepage link
