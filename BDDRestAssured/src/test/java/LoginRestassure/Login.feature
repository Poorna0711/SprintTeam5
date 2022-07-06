Feature: End-to-end functionality
Given I have the base URL

Scenario: Fetch pet by Status
When I request for pet details
Then I get pet details

Scenario: Fetch a pet by Id
When I request for pet details by id
Then I get pet information

Scenario: Delete a pet
When I delete a pet
Then The pet gets deleted

Scenario: Update pet details
When I update a pet detail  
|53|browny|sold|
Then The pet details updated

Scenario: place order
When place order for a pet
|2|23|1|
Then order is placed

Scenario: Fetch order by oderId
When I request for order details by id
Then I get order information

Scenario: Delete a order
When I delete a order
Then The order gets deleted

Scenario: get user with username
When get user with username
Then gets user details

Scenario: login user
When login user with "<username>" and "<password>"
|coco|string|
Then user got loggedin