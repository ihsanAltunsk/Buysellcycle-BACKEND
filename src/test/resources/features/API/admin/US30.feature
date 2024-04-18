#Reporter : Azim Kaya
  Feature: As an administrator, I want to be able to update
    coupon information with the specified ID number via the API connection.

  Scenario:TC-01 When a PATCH request body containing valid authorization information, the coupon ID to be updated,
  and necessary data (title, coupon_code, coupon_type, start_date, end_date, discount, discount_type,
  minimum_shopping, maximum_discount, is_expire, is_multiple_buy) is sent tothe /api/coupon/couponUpdate/{id} endpoint,
  the returned status code should be 202, and the message information in the response body should be verified
  as "coupon updated successfully".

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/refundReasonUpdate" path parameters

  Scenario:TC-02 When a PATCH request body containing valid authorization information and an incorrect
  (non-existent in the system) coupon ID, along with necessary data (title, coupon_code, coupon_type,
  start_date, end_date, discount, discount_type,minimum_shopping, maximum_discount, is_expire,
  is_multiple_buy), is sent to the /api/coupon/couponUpdate/{id} endpoint, the returned status code
  should be 404, and the message information in the response body should be verified as "coupon not found".

  Scenario:TC-03
