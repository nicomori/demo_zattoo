@example
Feature: Verify the message to confirm we are recording a movie

  Scenario Outline: access to the app and record a movie and verify the popup.

    Given access to the chrome
    Then access to this url "<url>"
    And make the login to access with this user "<user>" and this password "<password>"
    And make click in the sub menu movies
    Then make click in the options of the first movie
    Then make click in the option to record the movie and verify the popup

    Examples: 
      | url						 			 	| user  	| password 	| 
      | https://1und1-react-staging.zattoo.com 	| zattoo21	| Berlin53	| 