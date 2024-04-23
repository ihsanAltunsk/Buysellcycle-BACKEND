#Reporter : Senayda Akkaya
#US Priority : HIGH
@API
  Feature: As a user/administrator, I should be able to create a new customer record in the system via API connection.
  Background:
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/register" path parameters

    Scenario: TC01 User verifies whether a customer created through the API using an API connection exists in the customer list.

      * The api user prepares a POST request body for register "senayda", "akkaya", "iksdee@api.com", "123123123", "123123123", "customer", "01010101010".
      * The API user sends a "POST" request and records the response.
      * The api user verifies that the status code is 201
      * The api user verifies that the message information in the response body is "Successfully registered"
      * The API user saves the response body id
      * The api user constructs the base url with the "admin" token.
      * The api user sets "api/get-users" path parameters
      * The API user sends a "GET" request and records the response.
      * The API users checks customer added's id

    Scenario: TC02 User verify the accuracy of the response body when registering a customer via the /api/register endpoint,
                      both for valid and invalid scenarios.

        * The api user prepares a POSTBODY request containing the id = 419 and records the response.
        * The api user verifies the content of the data "senayda", "akkaya", "iksdee@api.com", "123123123", "123123123", "customer", "01010101010" in the response body.
        * The api user verifies that the status code is 422
        * The api user verifies that the message information in the response body is "The email has already been taken."


     Scenario: TC03 User verify the accuracy of the response body when registering a customer via the
                  /api/register endpoint, both for valid and invalid scenarios.

       * The api user prepares a POST request body for register "senayda", "akkaya", "123123123", "123123123", "customer", "01010101010".
       * The API user sends a "POST" request and records the response.
       * The api user verifies that the status code is 422
       * The api user verifies that the message information in the response body is "The email field is required."
       * The api user prepares a POST request body for register "senayda", "akkaya", "iksdee@api.com", "123123123", "customer", "01010101010".
       * The api user verifies that the status code is 422
       * The api user verifies that the message information in the response body is "The password field is required."


    Scenario: TC04 Confirms that the status code returned when the user submits the given information is 422 and the
              response message information is "Password confirmation does not match."




    Scenario: TC05 When the user sends the given information, it should be verified that the status code
                      returned is 422 and the response message is "The password field minimum 8 characters.".






