Feature: Leaftaps functionality

Background: 
Given Open the chrome browser
And Load the application url as 'http://leaftaps.com/opentaps/'
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And Click the login button
And Click the CRMSFA link
And Click the Lead button



Scenario: Test the duplicatelead functionality
Given Click the FindLeads link
And Click the phone button
And Enter the phonenumber as '99'
And Click the FindLeads button
Then Click the first row leadid
And Click the duplicate button		
Given Click the submit link
Then Duplicate lead is created