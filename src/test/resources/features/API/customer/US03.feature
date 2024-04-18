#Reporter : İhsan Altunışık
  Feature: As a user, I should be able to access the financial information of the customer via API connection.
    Scenario: Detailed information of the customer data with valid authorization credentials should be accessible via the API connection.
      * The api user constructs the base url with the "customer" token.
      * The api user sets "api/profile/get-customer-data" path parameters
      * The API user sends a GET request and records the response.
      * The api user verifies that the status code is 200
      * The api user verifies that the message information in the response body is "success"

    Scenario: Information of the customer data with invalid authorization credentials should not be accessible via the API connection.
      * The api user constructs the base url with the "invalid" token.
      * The api user sets "api/profile/get-customer-data" path parameters
      * The API user sends a GET request and records the response.
      * The api user verifies that the status code is 401
      * The api user verifies that the message information in the response body is "Unauthenticated."
