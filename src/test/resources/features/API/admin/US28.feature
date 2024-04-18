#Reporter : Doruk Özgen

Feature: US28 As an administrator, I want to be able to access the details of the coupon with the specified ID number via the API connection.

  Scenario: TC01 Admin should be able to view and verify the details of the valid authorization and valid coupon by entering its id via API.
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/departmentDetails" path parameters
    * The api user prepares a GETBODY request containing the id = 25 for which details are to be accessed, to send to the api endpoint.
    * The API user sends a GETBODY request and records the response.
    * The api user verifies that the status code is 200
    * The api user verifies that the message information in the response body is "success"
