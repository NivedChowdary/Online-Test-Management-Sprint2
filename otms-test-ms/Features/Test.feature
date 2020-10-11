Feature: Check Login

Scenario: Successful login with valid credentials
Given Admin is on login page
When Admin enters valid username and password
And Admin clicks on Login button
Then Admin should be able to see a message"Successfull login".

Scenario: Successfull Adding of Test
Given Admin has logged in to the website
When Admin clicks on Add Test button
And Admin fills the Test details
And Admin clicks on Add button
Then Admin view message as "Test Added Successfully"

Scenario: Successfull Deleting of Test
Given Admin has logged in to the website
When Admin clicks on Delete Test button
And Admin fills the Test details like Id
And Admin clicks on Delete button
Then Admin view message as "Test Deleted Successfully"

Scenario: Successfull Updating of Test
Given Admin has logged in to the website
When Admin clicks finds appropriate test id
And Admin fills the Test details which we want to modify
And Admin clicks on Update button
Then Admin view message as "Test Updated Successfully"

Scenario: Successful logout of User
Given Admin in on the website
When Admin clicks on Logout button
Then Admin should be able to see login button.

