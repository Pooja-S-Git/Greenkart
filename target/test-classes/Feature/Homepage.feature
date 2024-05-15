Feature: To check the functionality of homepage
    Adding product to cart and price in the cart is same as in home page
Scenario: Check user is able to access home page and add product to cart

Given User able to open URL
When User on homepage and able to add 10th item to cart
And Click cart icon in homepage
And User able to view selected item in cart
Then User able to view price in the cart and check same as in home page

