#Reporter : Doruk Özgen

Feature: US27 As an administrator, I want to be able to access coupon information via the API connection.

  Scenario: TC01 Admin should be able to view and validate coupon list with valid authorization information via API.
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/coupon/couponList" path parameters
    * The api user prepares a GET request to send to the api couponList endpoint.
    * The api user sends the GET request and saves the response returned from the api couponList endpoint.
    * The api user verifies that the status code is 200
    * The api user verifies that the message information in the response body is "success"

  Scenario: TC02 Admin should not be able to view the coupon list with invalid authorization information via the API and should receive a 401 error response.
    * The api user constructs the base url with the "invalid" token.
    * The api user sets "api/coupon/couponList" path parameters
    * The api user prepares a GET request to send to the api couponList endpoint.
    * The api user sends the GET request and saves the response returned from the api couponList endpoint.
    * The api user verifies that the status code is 401
    * The api user verifies that the message information in the response body is "Unauthenticated."

