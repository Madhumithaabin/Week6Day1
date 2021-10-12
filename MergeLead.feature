Feature: Leaftaps functionality

Background: 
Given Open the chrome browser
And Load the application url as 'http://leaftaps.com/opentaps/'
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And Click the login button
And Click the CRMSFA link
And Click the Lead button



Scenario: Test the mergelead functionality
Given Click the MergeLeads link
And Click the from search button
When New windows open,switch to new window
Then Enter the firstname as 'Gomathi'
And Click the FindLeadslink button
When Records will be displayed in the table,capture the leadid from the first row
Then Click the first row leadid
When New windows closes,switch to old window
And Click the to search button
When New windows open,switch to new window
Then Enter the firstname as 'Smitha'
And Click the FindLeadslink button
Then Click the first row leadid
When New windows closes,switch to old window
And Click the merge button
When Alert appears accept it
And Click the FindLeads button
Given Enter the lead as captured before		
And Click the FindLeadslink button
Then Verify if the data is merged
	