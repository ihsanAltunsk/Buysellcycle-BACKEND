#Reporter : İhsan Altunışık
  Feature:
    @API
    Scenario:
      * The api user constructs the base url with the "admin" token.
      * The api user sets "api/refundReasonAdd" path parameters
      * The api user verifies that the status code is 201
      * The api user verifies that the message information in the response body is "refundReason added successfully"
