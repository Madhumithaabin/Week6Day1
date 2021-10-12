Feature: Leaftaps functionality

Background: 
Given Open the chrome browser
And Load the application url as 'http://leaftaps.com/opentaps/'
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And Click the login button
And Click the CRMSFA link
And Click the Lead button


Scenario Outline: Test the createlead functionality
Given Click the CreateLead button
Given Enter the companyName as <CName>
Given Enter the FirstName as <FName>
Given Enter the LastName as <LName>
Given Enter the Phonenumber as <phoneno>
When Click the createlead button
Then New lead is created		
		Examples:
		| CName | FName | LName | phoneno |
		| 'HCL' | 'Madhumitha' |'Murugan' | '9840768866'|
		| 'IBM' | 'Priya' |'Sivaraan' | '9834368866'|
		| 'Accenture' | 'Thehjesh' |'Dinakaran' | '8840790866'|
		| 'HP' | 'Pradeep' |'Subramanian' | '9898767866'|


#Scenario: Test with negative functionality
#Given Open the chrome browser
#And Load the application url as 'http://leaftaps.com/opentaps/'
#And Enter the username as 'Demosalesmanager'
#And Enter the password as 'crmsfa'
#When Click the login button
#But Errorpage is displayed