#Reporter : Doruk Özgen

Feature: US28 As an administrator, I want to be able to access the details of the coupon with the specified ID number via the API connection.

  Scenario Outline: TC01 Admin should be able to view and verify the details of the valid authorization and valid coupon by entering its id via API.
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/departmentDetails" path parameters
    * The api user prepares a GET request containing the <id> information to send to the api couponDetails endpoint.
    * The api user sends the GET request and saves the response returned from the api couponDetails endpoint.
    * The api user verifies that the status code is 200
    * The api user verifies that the message information in the response body is "success"


    Examples:
      | id |
      | 25 |