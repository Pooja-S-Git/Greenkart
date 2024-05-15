Feature: To check the functionality of promocode 
Scenario: Check user entered promocode is valid or not

Given User able to open URL and view homepage
When User can select the multiple item and add to cart
And User able to view cart of selected item
And User able to remove 3rd  item in cart
And Click Proceed to checkout button in cart
And Click apply button and alerted as empty code
And User able to enter promo code
Then User able to view invalid promo code is applied

