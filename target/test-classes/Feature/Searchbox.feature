Feature: To check the functionality of calculating the price of searched product according to quantity
Scenario: Check user is able to view the correct quantity and price of selected product

Given User able to the open url
When User on the homepage and search for product
And Click increment icon of product
And Click add to cart button
And User able to click the cart icon
Then User able to view calculated price and quantity of selected item
