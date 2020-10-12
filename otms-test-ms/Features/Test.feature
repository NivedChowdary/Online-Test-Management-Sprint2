Feature: Check Login

Scenario: Successful login with valid credentials and adding test and logout
Given Admin is on login page
When Admin enters valid username and password
And Admin clicks on Login button
Then Admin should be able to see a message"Successfull login".


#Scenario: Successfull Adding of Test
Given Admin has logged in to the website
When Admin clicks on Add Test button
And Admin fills the Test details
And Admin clicks on Add button
Then Admin view message as "Test Added Successfully".

#Scenario: Successfull Logut of Site
Given Admin has logged in to the website
When Admin clicks on Logut button 
Then Browser window must be closed.



