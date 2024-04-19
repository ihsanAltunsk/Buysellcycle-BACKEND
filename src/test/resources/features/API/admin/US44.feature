#Reporter : Reyyan Mert
  Feature: As an administrator, I want to be able to delete the address information of the customer with the specified
    ID number via the API connection.

Scenario Outline: When a DELETE request body containing valid authorization information and the address ID to be deleted
is sent to the /api/profile/deleteAddress endpoint, the returned status code should be 202, and the message in the response
body should confirm that it is "address deleted successfully".

  * The api user constructs the base url with the "admin" token.
  * The api user sets "api/profile/deleteAddress" path parameters
  * The api user prepares a DELETE request containing the refund reason <id> to be deleted to send to the api deleteAddress endpoint.
  * The api user sends the DELETE request and saves the response returned from the api deleteAddress endpoint.
  * The api user verifies that the status code is 202
  * The api user verifies that the message information in the response body is "address deleted successfully"
  * The api user verifies that the Deleted <id> information in the response body is the same as the id information in the request body.


  Examples:
    |id |
    |255|

  Scenario Outline: When a DELETE request body containing valid authorization information and an incorrect (non-existent in the system)
  address ID is sent to the /api/profile/deleteAddress endpoint, the returned status code should be 404, and the message in the response
  body should confirm that it is "address not found".

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/deleteAddress" path parameters
    * The api user prepares a DELETE request containing the refund reason <id> to be deleted to send to the api deleteAddress endpoint.
    * The API user records the response from the api deleteAddress endpoint, confirming that the status code is '404' and the reason phrase is Not Found.

    Examples:
      |id |
      |1025|

    Scenario Outline: When a DELETE request body containing invalid authorization information and the address ID to be deleted is
    sent to the /api/profile/deleteAddress endpoint, the returned status code should be 401, and the message in the response
    body should confirm that it is "Unauthenticated.".

      * The api user constructs the base url with the "invalid" token.
      * The api user sets "api/profile/deleteAddress" path parameters
      * The api user prepares a DELETE request containing the refund reason <id> to be deleted to send to the api deleteAddress endpoint.
      * The API user saves the response from the api deleteAddress endpoint, verifying that the status code is '401' and the reason phrase is Unauthorized.

      Examples:
        |id |
        |257|


