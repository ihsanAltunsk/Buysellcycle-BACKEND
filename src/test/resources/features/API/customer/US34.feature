#Reporter : İhsan Altunışık
  Feature: As a user, I want to add a new address record to my profile via API connection.
    Scenario: The user should perform a valid POST request.
      * The api user constructs the base url with the "customer" token.
      * The api user sets "api/profile/address-store" path parameters
      * The api user prepares a POST request body for address-store.
      * The API user sends a "POST" request and records the response.
      * The api user verifies that the status code is 201
      * The api user verifies that the message information in the response body is "address added successfully"

    Scenario: The user should not perform POST request with valid authorization information and an invalid email.
      * The api user constructs the base url with the "customer" token.
      * The api user sets "api/profile/address-store" path parameters
      * The api user prepares a invalid POST request body for address-store.
      * The API user sends a "POST" request and records the response.
      * The api user verifies that the status code is 422
      * The api user verifies that the message information in the response body is "The email must be a valid email address."

    Scenario: The user should not perform POST request with invalid authorization information.
      * The api user constructs the base url with the "invalid" token.
      * The api user sets "api/profile/address-store" path parameters
      * The api user prepares a POST request body for address-store.
      * The API user sends a "POST" request and records the response.
      * The api user verifies that the status code is 401
      * The api user verifies that the message information in the response body is "Unauthenticated."
