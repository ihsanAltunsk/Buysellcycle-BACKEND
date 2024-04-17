#Reporter : Hümeyra Tayfun
  Feature: As an administrator, I want to be able to update the Refund&Reason information
    with the specified ID number via the API connection.

   @20
    Scenario Outline: When a PATCH request body containing valid authorization information, the Refund&Reason ID to be updated,
    and necessary data (reason) is sent to the /api/refundReasonUpdate/{id} endpoint, the returned status code
    should be 202, and the message information in the response body should be verified as "refundReason updated successfully".

      * The api user constructs the base url with the "admin" token.
      * The api user sets "api/refundReasonUpdate/<id>" path parameters
      * The api user prepares a PATCH request containing the "<reason>" data to send to the api refundReasonUpdate endpoint.
      * The api user sends the PATCH request and saves the response returned from the api refundReasonUpdate endpoint.
      * The api user verifies that the status code is 202
      * The api user verifies that the message information in the response body is "refundReason updated successfully"
      * The api user verifies that the updated id information in the response body matches the id path parameter specified in the endpoint.

      Examples:
      Examples:
        | id | reason                 |
        | 25 | Product arrived lately |