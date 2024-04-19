#Reporter : Azim Kaya

Feature:Bir yönetici olarak API baglantisi üzerinden belirtilen state_id ile sisteme kayitli city bilgilerine erisebilmek istiyorum.

  Scenario:TC-01 /api/profile/stateCities endpoint'ine gecerli authorization bilgileri ve city bilgilerine erisebilmek istenen state_id'sini iceren bir GET request body  gönderildiginde dönen status code'in 200 ve message bilgisinin "success" oldugu dogrulanmali

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/stateCities" path parameters
    * The API user sends a GET request and records the response.
    * The api user verifies that the status code is 200
    * The api user verifies that the message information in the response body is "success"

  Scenario :TC-02/api/profile/stateCities endpointine gecerli authorization bilgileri ve state_id olarak 3669  girilip GET request body icerisinde gönderilince dönen response body'de id numarasi 40325 olan city'in "name" bilgisinin "Kizilcahamam" oldugunu dogrulanmali.

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/stateCities" path parameters
    * The API user sends a GET request and records the response from the api refundReasonList endpoint.

  Scenario:TC-03/api/profile/stateCities endpoint'ine gecerli authorization bilgileri ve yanlis (sistemde bulunmayan) state_id iceren bir GET request body gönderildiginde dönen status code'in 404 ve message bilgisinin "address not found" oldugu dogrulanmali.

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/stateCities" path parameters
    * The API user sends a GET request and records the response.
    * The api user verifies that the status code is 404
    * The api user verifies that the message information in the response body is "address not found"

  Scenario:TC-04/api/profile/stateCities endpoint'ine gecersiz authorization bilgileri ve city bilgilerine erisebilmek istenen state_id'sini iceren bir GET request body gönderildiginde dönen status code'in 401 ve message bilgisinin "Unauthenticated." oldugu dogrulanmali.
    * The api user constructs the base url with the "invalidToken" token.
    * The api user sets "api/profile/stateCities" path parameters
    * The API user sends a GET request and records the response.
    * The api user verifies that the status code is 401
    * The api user verifies that the message information in the response body is "Unauthenticated."