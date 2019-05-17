Feature: Hotel Booking
  As a user of the hotel website,
  I want to be able to create and delete bookings
  So that I can manage my stay at the hotel independently
  
  Background:
  Given a web browser is on the hotel booking page 
  
  Scenario Outline: Create a hotel booking
  
    When the user provides the required details to make a valid booking
	| <First Name> | <Last Name> | <Price> | <Deposit> | <Check-in> | <Check-out> |
    And submits the request
    Then the booking is successfully displayed in the Bookings table
    
    Examples:
	| First Name | Last Name | Price      | Deposit  | Check-in   | Check-out  |
	| Ben	 	 | McTest 	 | 3999.99	  | true	 | 2019-06-01 |	2019-07-20 |
	| Emily	 	 | O'Brien	 | 2500	      | false	 | 2020-10-02 |	2019-10-15 |
	
  Scenario Outline: Delete a hotel booking
  
    When the user creates a new booking
	| <First Name> | <Last Name> | <Price> | <Deposit> | <Check-in> | <Check-out> |
    And then deletes the request
    Then the booking is successfully removed from the Bookings table
    
    Examples:
	| First Name | Last Name | Price      | Deposit  | Check-in   | Check-out  |
	| Rick	 	 | Morty 	 | 100.00	  | true	 | 2019-09-20 |	2019-09-27 |