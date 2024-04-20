#Reporter : Azim Kaya
Feature: As an administrator, I want to be able to add a new Refund&Reason record to the system via
Scenario Outline:TC-01 When a POST body containing valid authorization information and necessary data
  * The api user constructs the base url with the "admin" token.
  * The api user sets "api/refundReasonAdd" path parameters
  * The api user prepares a POST request containing the "<reason>" information to send to the api refundReasonAdd endpoint.
  * The api user sends the POST request and saves the response returned from the api refundReasonAdd endpoint.
  * The api user verifies that the status code is 201
  * The api user verifies that the message information in the response body is "refundReason added successfully"
  Examples:
|     reason       |
| product mismatch |

Scenario:TC-02 The creation of the new Refund&Reason record via the API should be verified.
  * The api user constructs the base url with the "admin" token.
  * The api user sets "api/refundReasonDetails" path parameters
  * The api user prepares a GETBODY request containing the id = 50 and records the response.
  * The api user verifies that the message information in the response body is "success"

Scenario Outline:TC-03 When a POST body containing invalid authorization information and necessary
    * The api user constructs the base url with the "invalid" token.
    * The api user sets "api/refundReasonAdd" path parameters
    * The api user prepares a POST request containing the "<reason>" information to send to the api refundReasonAdd endpoint.
    * The api user sends the POST request and saves the response returned from the api refundReasonAdd endpoint.
    * The api user verifies that the status code is 401
    * The api user verifies that the message information in the response body is "Unauthenticated."

      Examples:
      | reason           |
      | product mismatch |