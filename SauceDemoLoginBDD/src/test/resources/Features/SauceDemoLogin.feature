
Feature: As a newspaper reader I want to login and check the

    Scenario:  Login Successfully to the saucedemo homepage
        Given the user is on the Newspaper login page
        When the user enters valid credentials <userid>
        And user clicks on the login button
        Then the user is redirected to the homepage
        And the user logout successfully
        
        @user1
        Examples: 
      	| userid  				|
 				| standard_user   |
 				
 				@user2
        Examples: 
      	| userid  				|
 				| problem_user		|
 				
 				@user3
        Examples: 
      	| userid  				|
 				| error_user		|
        
        
  
        
        