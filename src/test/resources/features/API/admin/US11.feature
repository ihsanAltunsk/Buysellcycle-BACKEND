#Reporter : Senayda Akkaya
#US Priority : HIGH

  Feature: As an administrator, I want to be able to delete holiday information for the specified id number via API connection.

    Scenario: TC01 User verify that the DELETE body with valid authorization and holiday ID is successfully deleted,with a status code of 202.


    Scenario: TC02 User confirms that when a DELETE body is sent with valid authorization information but an incorrect holiday ID,
              the response body displays a 404 status code and "holiday not found".


    Scenario: TC03 The user verifies that when a DELETE body is sent containing invalid authorization information
    and the holiday id to be deleted, the status code returned is 401 and the message in the response body is "Unauthenticated."


    Scenario: TC04 User should verify that the Deleted_Id in the response body returned from the /api/holidayDelete
    endpoint is the same as the id in the DELETE request body sent to the /api/holidayDelete endpoint.


    Scenario: TC05 User confirm if the requested holiday record from the API has been deleted by sending a GET request
        to the /api/holidayDetails endpoint with the Deleted_Id returned.