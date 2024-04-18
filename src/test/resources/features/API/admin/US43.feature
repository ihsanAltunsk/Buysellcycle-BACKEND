#Reporter : Reyyan Mert

  Feature: As an administrator, I want to be able to update the existing address information of a customer with the
    specified address ID number and belonging customer_id via the API connection.

  Scenario Outline: When a PATCH request body, containing the address ID and the correct customer_id, along with valid authorization
  information, is sent to the api/profile/addressUpdate/{id} endpoint for update, with fields (customer_id, name, email, address,
  phone, city, state, country, postal_code, address_type), the returned status code should be 202, and the message in the response
  body should confirm that it is "address updated successfully".

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressUpdate/{id} " path parameters
    * The api user prepares a PATCH request containing the "<customer_id>", "<name>",  "<email>", "<address>", "<phone>", "<city>",  "<state>",  "<country>",   "<postal_code>",  "<address_type>",  data to send to the api address Update endpoint.
    * The api user sends the PATCH request and saves the response returned from the api address Update endpoint.
    * The api user verifies that the status code is 202
    * The api user verifies that the message information in the response body is "address updated successfully"
    * The api user verifies that the updated id information in the response body matches the id path parameter specified in the endpoint.