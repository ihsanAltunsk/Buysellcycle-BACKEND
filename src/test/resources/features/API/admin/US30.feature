#Reporter : Azim Kaya
  Feature: As an administrator, I want to be able to updatecoupon information with the specified ID number via the API connection.

  Scenario:TC-01 When a PATCH request body containing valid authorization information, the coupon ID to be updated,
  and necessary data

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/coupon/couponUpdate/45" path parameters
    * The api user prepares a PATCH request body for couponUpdate.
    * The API user sends a PATCH request and records the response.
    * The api user verifies that the message information in the response body is "coupon updated successfully"
    * The api user verifies that the status code is 202

  Scenario:TC-02 When a PATCH request body containing valid authorization information and an incorrect

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/coupon/couponUpdate/47777" path parameters
    * The api user prepares a PATCH request body for couponUpdate.
    * The API user sends a PATCH request and records the response.
    * The api user verifies that the status code is 404
    * The api user verifies that the message information in the response body is "coupon not found"

  Scenario Outline:TC-03 When a PATCH request body containing invalid authorization information,along with the coupon ID to be updated and necessary data

    * The api user constructs the base url with the "invalidToken" token.
    * The api user sets "api/coupon/couponUpdate/45" path parameters
    * The api user prepares a PATCH request body for couponUpdate.
    * The API user sends a PATCH request and records the response.
    * The api user prepares a PATCH request containing the "<reason>" data to send to the api refundReasonUpdate endpoint.
    * The API user records the response from the api refundReasonUpdate endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.


    Examples:
      | id |
      | 45 |

  Scenario:TC-04 The updated_Id information in the response body from the /api/coupon/couponUpdate/{id}
  endpoint should be verified to be identical to the id path parameter written in the /api/coupon/couponUpdate/{id} endpoint.

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/coupon/couponUpdate/45" path parameters
    * The api user prepares a PATCH request body for couponUpdate.
    * The API user sends a PATCH request and records the response.
    * The api user verifies that the updated id information in the response body matches the 45 path parameter specified in the endpoint.


  Scenario Outline: TC-05 The update of the coupon record via the API should be verified from the API itself.

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/coupon/couponUpdate/45" path parameters
    * The API user sends a GETBODY request and records the response.
    * The api user verifies that the updated id information in the response body matches the <id> path parameter specified in the endpoint.

      Examples:
        | id |
        | 45 |