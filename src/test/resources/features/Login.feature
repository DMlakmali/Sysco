Feature: Login functionality
  As a valid user
  I want to login to the system
  So that I can access my account

  Scenario: Successful login with valid credentials
  Given user is on the login page
  When user enters valid "<email>"
  And user clicks on next button
  And user enters valid "<email>" again
   And user clicks on next button again
  And user enters username "<username>"
   And user clicks on next button to proceed
    And user enters password  "<password>"
   And clicks the login button
    And user clicks on submit button to stay signed in
  Then user should be navigated to the home page

   
     Examples:
     | email| username | password | 
      |cxweb013@sysco.com|  cxweb013  |cr7dUfsnpqgHIj| 
    