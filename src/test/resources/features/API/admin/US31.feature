#Reporter : Azim Kaya
Feature:As an administrator, I want to be able to update coupon information with the specified ID number via the API connection.

Scenario:TC-01 When a DELETE body containing valid authorization information and the coupon ID to be deleted is sent to the /api/coupon/couponDelete endpoint, the returned status code should be 202, and the message information in the response body should be verified as "coupon deleted successfully".
  * The api user constructs the base url with the "admin" token.
  * The api user sets "api/coupon/couponDelete" path parameters
  * The api user prepares a DELETE  request containing the id = 57 for which details are to be accessed, to send to the api endpoint.
  * The api user sends the DELETE request and saves the response returned from the api refundReasonDelete endpoint.
  * The api user verifies that the status code is 202
  * The api user verifies that the message information in the response body is "coupon deleted successfully"
  @AZ
Scenario:TC-02 When a DELETE body containing valid authorization information and an incorrect (non-existent in the system) coupon ID is sent to the /api/coupon/couponDelete endpoint, the returned status code should be 404, and the message information in the response body should be verified as "coupon not found".
  * The api user constructs the base url with the "admin" token.
  * The api user sets "api/coupon/couponDelete" path parameters
  * The api user prepares a DELETE  request containing the id = 57777 for which details are to be accessed, to send to the api endpoint.
  * The api user sends the DELETE request and saves the response returned from the api refundReasonDelete endpoint.
  * The api user verifies that the status code is 404
  * The api user verifies that the message information in the response body is "coupon not found"

Scenario:TC-03 When a DELETE body containing invalid authorization information and the coupon ID to be deleted is sent to the /api/coupon/couponDelete endpoint, the returned status code should be 401, and the message information in the response body should be verified as "Unauthenticated.".
  * The api user constructs the base url with the "invalidToken" token.
  * The api user sets "api/coupon/couponDelete" path parameters
  * The api user prepares a DELETE  request containing the id = 57 for which details are to be accessed, to send to the api endpoint.
  * The api user sends the DELETE request and saves the response returned from the api refundReasonDelete endpoint.

Scenario:TC-04 The Deleted_Id information in the response body returned from the /api/coupon/couponDelete endpoint should be verified to match the id information in the DELETE request body sent to the same /api/coupon/couponDelete endpoint.
  * The api user constructs the base url with the "admin" token.
  * The api user sets "api/coupon/couponDelete" path parameters

Scenario:TC-05 The deletion of the coupon record via the API should be verified from the API itself.(The deletion of the record can be confirmed by sending a GET request to the /api/coupon/couponDetails endpoint with the Deleted_Id returned in the response body.)
  * The api user constructs the base url with the "admin" token.
  * The api user sets "api/coupon/couponDelete" path parameters