Feature: Log in to PetStoreDemo
Background: User is already registered with PetStoreDemo
@Login
Scenario Outline: Login through valid credentials.
	Given User is on login page
	When User enters <username> and <password>
	And User clicks on login
	Then Logged in successfully

	Examples: 
	| username | password |
	| Team5  |Team5|