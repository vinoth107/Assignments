Feature: Demo Insurance Registration

  Scenario: Register online insurance login with guru99
   Given User is on Home Page
   When User Navigate to Registration Page
   And User fill the form details
   |FirstName|Vinoth Kumar|
   |SureName|Nallasamy|
   |PhoneNum|9864311624|
   |street|VKG|
	 |city|Chennai|
	 |county|India|
	 |post_code|600119|
	 |email|vinoth@gmail.com|
	 |password|hello|
	 |c_password|hello|
   Then User get the Registration Successfully message
