Feature: To check the functionality of flight booking page.
Scenario: Check user is able to navigate flight booking page and try to book flight

Given User is able to open URL in the browser and view the home page
When Click Flight booking link
And User able to enter country name and pick from the list
And Click flight title
And Click round trip radio button
And User choose FROM location and TO location
And User able to click the depart and return date
And Click number of passenger according to the catagory
And Click currency option from dropdown
And Click Friends and family radio button
And User able to click search option 
Then Click accept alert and search
