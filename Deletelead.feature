Feature: Leaftaps functionality

Background: 
Given Open the chrome browser
And Load the application url as 'http://leaftaps.com/opentaps/'
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And Click the login button
And Click the CRMSFA link
And Click the Lead button



Scenario: Test the deletelead functionality
Given Click the FindLeads link
And Click the phone button
And Enter the phonenumber as '99'
And Click the FindLeads button
When Records will be displayed in the table,capture the leadid from the first row
Then Click the first row leadid
And Click the delete button		
Given Click the FindLeads link
Given Enter the leadid as captured before
And Click the FindLeads button
Then Verify the record is deleted 
