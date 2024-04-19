package stepdefinitions;

import com.github.javafaker.Faker;
import config_Requirements.ConfigReader;

import hooks.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.Pojo;
import utilities.API_Utilities.API_Methods;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNull;

public class API_Stepdefinitions extends Base {

    public static int id;
    public static String fullPath;
    public static JSONObject requestBody;
    public static Random random;
    JsonPath jsonPath;
    HashMap<String, Object> reqBody;
    public static Faker faker;

    //Reyyan US08-TC01
    @Given("The api user verifies the content of the data {int}, {string}, {string}, {int}, {string},{string},{string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(int id, String year, String name, int type, String date, String created_at , String updated_at ) {
        jsonPath = API_Methods.response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("holidayDetails[0].id"));
        Assert.assertEquals(year, jsonPath.getString("holidayDetails[0].year"));
        Assert.assertEquals(name, jsonPath.getString("holidayDetails[0].name"));
        Assert.assertEquals(type, jsonPath.getInt("holidayDetails[0].type"));
        Assert.assertEquals(date, jsonPath.getString("holidayDetails[0].date"));
        Assert.assertEquals(created_at, jsonPath.getString("holidayDetails[0].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("holidayDetails[0].updated_at"));
    }

    @Given("The api user verifies the content of the data {int}, {string},{string},{string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(int id, String reason, String created_at, String updated_at) {
        jsonPath = API_Methods.response.jsonPath();

        Assert.assertEquals(id,jsonPath.getInt("refundReasonDetails[0].id"));
        Assert.assertEquals(reason,jsonPath.getString("refundReasonDetails[0].reason"));
        Assert.assertEquals(created_at,jsonPath.getString("refundReasonDetails[0].created_at"));
        Assert.assertEquals(updated_at,jsonPath.getString("refundReasonDetails[0].updated_at"));
    }

    @Given("The api user verifies the content of the data {string},{string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(String name, String details) {
        jsonPath = API_Methods.response.jsonPath();
        Assert.assertEquals(name,jsonPath.getString("departments[0].name"));
        Assert.assertEquals(details,jsonPath.getString("departments[0].details"));
    }

    //Reyyan US29-TC01
    @Given("The api user prepares a POST request containing the {string}, {string}, {int}, {string}, {string}, {int}, {int}, {int}, null, {int}, {int} information to send to the api couponAdd endpoint.")
    public void the_api_user_prepares_a_post_request_containing_the_null_information_to_send_to_the_api_coupon_add_endpoint(String title, String coupon_code, int coupon_type, String start_date, String end_date, int discount, int discount_type, int minimum_shopping, int is_expire, int is_multiple_buy) {
        requestBody.put("title",title);
        requestBody.put("coupon_code",coupon_code);
        requestBody.put("coupon_type",coupon_type);
        requestBody.put("start_date",start_date);
        requestBody.put("end_date",end_date);
        requestBody.put("discount",discount);
        requestBody.put("discount_type",discount_type);
        requestBody.put("minimum_shopping",minimum_shopping);
        requestBody.put("maximum_discount",nullValue());
        requestBody.put("is_expire",is_expire);
        requestBody.put("is_multiple_buy",is_multiple_buy);
    }
    //Reyyan US43-TC01
    @Given("The api user prepares a PATCH request containing the {int}, {string}, {string}, {string}, {string}, {string},{string}, {string}, {string}, {string} data to send to the api address Update endpoint.")
    public void the_api_user_prepares_a_patch_request_containing_the_data_to_send_to_the_api_address_update_endpoint(int customer_id, String name, String email, String address, String phone, String city, String state, String country, String postal_code, String address_type) {
        requestBody.put("customer_id",customer_id);
        requestBody.put("name",name);
        requestBody.put("email",email);
        requestBody.put("address",address);
        requestBody.put("phone",phone);
        requestBody.put("city",city);
        requestBody.put("state",state);
        requestBody.put("country",country);
        requestBody.put("postal_code",postal_code);
        requestBody.put("address_type",address_type);
        System.out.println(requestBody);
    }

    @Given("The API user verifies that the updated {int} information in the returned response body is the same as the id path parameter written in the endpoint.")
    public void the_apı_user_verifies_that_the_updated_ıd_information_in_the_returned_response_body_is_the_same_as_the_id_path_parameter_written_in_the_endpoint(int id) {
     jsonPath = API_Methods.response.jsonPath();
     int actualUpdateId = jsonPath.getInt("updated_Id");
     assertEquals(actualUpdateId,id);
    }

    @Given("The api user verifies that the reason information in the response body is {int}, {string}, {string}, {string}, {string}, {string},{string}, {string}, {string}, {string}.")
    public void the_api_user_verifies_that_the_reason_information_in_the_response_body_is(int customer_id, String name, String email, String address, String phone, String city, String state, String country, String postal_code, String address_type) {
        jsonPath = API_Methods.response.jsonPath();

        Assert.assertEquals(customer_id,jsonPath.getInt("addresses[0].customer_id"));
        Assert.assertEquals(name,jsonPath.getString("addresses[0].name"));
        Assert.assertEquals(email,jsonPath.getString("addresses[0].email"));
        Assert.assertEquals(address,jsonPath.getString("addresses[0].address"));
        Assert.assertEquals(phone,jsonPath.getString("addresses[0].phone"));
        Assert.assertEquals(city,jsonPath.getString("addresses[0].city"));
        Assert.assertEquals(state,jsonPath.getString("addresses[0].state"));
        Assert.assertEquals(country,jsonPath.getString("addresses[0].country"));
        Assert.assertEquals(postal_code,jsonPath.getString("addresses[0].postal_code"));
        //Assert.assertEquals(address_type,jsonPath.getString("addresses[0].address_type"));

    }
    //Reyyan US44-TC01-04-02-03-
    @Given("The api user prepares a DELETE request containing the refund reason {int} to be deleted to send to the api deleteAddress endpoint.")
    public void the_api_user_prepares_a_delete_request_containing_the_refund_reason_to_be_deleted_to_send_to_the_api_delete_address_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }

    @Given("The api user verifies that the Deleted {int} information in the response body is the same as the id information in the request body.")
    public void the_api_user_verifies_that_the_deleted_information_in_the_response_body_is_the_same_as_the_id_information_in_the_request_body(int id) {
        jsonPath = API_Methods.response.jsonPath();
        Assert.assertEquals(requestBody.get("id"), jsonPath.getInt("Deleted_Id"));
    }
    @Given("The API user records the response from the api deleteAddress endpoint, confirming that the status code is '404' and the reason phrase is Not Found.")
    public void the_apı_user_records_the_response_from_the_api_delete_address_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_not_found() {
        Assert.assertTrue(API_Methods.tryCatchDelete(requestBody.toString()).equals(ConfigReader.getProperty("api","notFoundExceptionMessage")));
    }
    @Given("The API user saves the response from the api deleteAddress endpoint, verifying that the status code is '401' and the reason phrase is Unauthorized.")
    public void the_apı_user_saves_the_response_from_the_api_delete_address_endpoint_verifying_that_the_status_code_is_and_the_reason_phrase_is_unauthorized() {
        Assert.assertTrue(API_Methods.tryCatchDelete(requestBody.toString()).equals(ConfigReader.getProperty("api","unauthorizedExceptionMessage")));
    }

    // ===============================================================================================================================================================================
    //Humeyra Tayfun
    @Given("The api user validates the {string} of the response body with index {int}.")
    public void the_api_user_validates_the_of_the_response_body_with_index(String reason, Integer dataIndex) {
       API_Methods.response.then()
               .assertThat()
               .body("refundReason["+ dataIndex+ "].reason",equalTo(reason));
    }

    @Given("The api user prepares a PATCH request containing the {string} data to send to the api refundReasonUpdate endpoint.")
    public void the_api_user_prepares_a_patch_request_containing_the_data_to_send_to_the_api_refund_reason_update_endpoint(String reason) {
        requestBody.put("reason",reason);
    }
    @Given("The api user verifies that the updated id information in the response body matches the {int} path parameter specified in the endpoint.")
    public void the_api_user_verifies_that_the_updated_id_information_in_the_response_body_matches_the_id_path_parameter_specified_in_the_endpoint(int id) {
        API_Methods.response.then()
                .assertThat()
                .body("updated_Id", equalTo(id));
    }
    
    @Given("The API user records the response from the api refundReasonUpdate endpoint, confirming that the status code is '404'and the reason phrase is Not Found.")
    public void the_apı_user_records_the_response_from_the_api_refund_reason_update_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_not_found() {
        Assert.assertTrue(API_Methods.tryCatchPatch(requestBody.toString()).equals(ConfigReader.getProperty("api","notFoundExceptionMessage")));
    }

    @Given("The API user records the response from the api refundReasonUpdate endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_refund_reason_update_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized() {
        Assert.assertTrue(API_Methods.tryCatchPatch(requestBody.toString()).equals(ConfigReader.getProperty("api","unauthorizedExceptionMessage")));
    }

    @Given("The api user sends a GET request and saves the response returned from the api refundReasonDetails endpoint.")
    public void the_api_user_sends_a_get_request_and_saves_the_response_returned_from_the_api_refund_reason_details_endpoint() {
        API_Methods.getBodyResponse(requestBody.toString());
    }
    @Given("The api user verifies that the reason information in the response body is {string}.")
    public void the_api_user_verifies_that_the_reason_information_in_the_response_body_is(String reasonValue) {
        jsonPath = API_Methods.response.jsonPath();
        Assert.assertEquals(reasonValue, jsonPath.getString("refundReasonDetails[0].reason"));
    }
    @Given("The api user prepares a POST request body for holiday add {string} {string} {string}.")
    public void the_api_user_prepares_a_post_request_body_for_holiday_add(String year, String name, String date) {
       requestBody.put("year",year);
       requestBody.put("name",name);
       requestBody.put("date",date);
    }
    @Given("The api user prepares a DELETE request containing the refund reason {int} to be deleted to send to the api refundReasonDelete endpoint.")
    public void the_api_user_prepares_a_delete_request_containing_the_refund_reason_to_be_deleted_to_send_to_the_api_refund_reason_delete_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id",id);
    }

    @Given("The api user verifies that the Deleted id information in the response body is the same as the id information in the request body.")
    public void the_api_user_verifies_that_the_deleted_id_information_in_the_response_body_is_the_same_as_the_id_information_in_the_request_body() {
        jsonPath = API_Methods.response.jsonPath();
        Assert.assertEquals(requestBody.get("id"), jsonPath.getInt("Deleted_Id"));
    }

    @Given("The api user validates the {string} {string} of the response body with index {int}.")
    public void the_api_user_validates_the_of_the_response_body_with_index(String year, String name, int dataIndex) {
        jsonPath = API_Methods.response.jsonPath();
        Assert.assertEquals(year, jsonPath.getString("holiday["+dataIndex+"].year"));
        Assert.assertEquals(name, jsonPath.getString("holiday["+dataIndex+"].name"));
    }

    //===================================================================================================================
    // Senayda US05-TC02
    @Given("The api user verifies the content of the data {int}, {string}, {string}, {string}, {string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(Integer id, String first_name, String username, String email, String name) {
    
    }

    @Given("The api user verifies the content of the data {int} {string}, {string}, {string} {int},{string},{string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(int id, String user_id , String title , String description , int status, String created_at, String updated_at) {
     jsonPath=API_Methods.response.jsonPath();
     Assert.assertEquals(id,jsonPath.getInt("faqDetails[0].id"));
     Assert.assertEquals(user_id,jsonPath.getString("faqDetails[0].user_id"));
     Assert.assertEquals(title,jsonPath.getString("faqDetails[0].title"));
     Assert.assertEquals(description,jsonPath.getString("faqDetails[0].description"));
     Assert.assertEquals(status,jsonPath.getInt("faqDetails[0].status"));
     Assert.assertEquals(created_at,jsonPath.getString("faqDetails[0].created_at"));
     Assert.assertEquals(updated_at,jsonPath.getString("faqDetails[0].updated_at"));
    }

    @Given("The api user prepares a PATCH request body for holiday add {string} {string} {string}.")
    public void the_api_user_prepares_a_patch_request_body_for_holiday_add(String year, String name, String date) {
        requestBody.put("year",year);
        requestBody.put("name",name);
        requestBody.put("date",date);
    }

    //======================================================================================================================================================================
    // Doruk US23 - TC01
    @Given("The api user prepares a POST request containing the department information to send to the api departmanAdd endpoint.")
    public void the_api_user_prepares_a_post_request_containing_the_department_information_to_send_to_the_api_departman_add_endpoint(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        System.out.println(rows);

        requestBody.put(rows.get(0).get(0), rows.get(1).get(0));
        requestBody.put(rows.get(0).get(1), rows.get(1).get(1));
        requestBody.put(rows.get(0).get(2), rows.get(1).get(2));
    }

    @Given("The api user prepares a GET request to send to the api couponList endpoint.")
    public void the_api_user_prepares_a_get_request_to_send_to_the_api_coupon_list_endpoint() {
        requestBody = new JSONObject();
    }

    // Doruk US28 - TC01
    @Given("The api user verifies the content of the data {int}, {string}, {string}, {int}, {string}, {string}, {int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}, {string}, {string}, {string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(int id, String title, String coupon_code, int coupon_type, String start_date, String end_date, int discount, int discount_type, int minimum_shopping, int maximum_discount, int created_by, int updated_by, int is_expire, int is_multiple_buy, String multiple_buy_limit, String created_at, String updated_at) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(id, jsonPath.getInt("couponDetails[0].id"));
        assertEquals(title, jsonPath.getString("couponDetails[0].title"));
        assertEquals(coupon_code, jsonPath.getString("couponDetails[0].coupon_code"));
        assertEquals(coupon_type, jsonPath.getInt("couponDetails[0].coupon_type"));
        assertEquals(start_date, jsonPath.getString("couponDetails[0].start_date"));
        assertEquals(end_date, jsonPath.getString("couponDetails[0].end_date"));
        assertEquals(discount, jsonPath.getInt("couponDetails[0].discount"));
        assertEquals(discount_type, jsonPath.getInt("couponDetails[0].discount_type"));
        assertEquals(minimum_shopping, jsonPath.getInt("couponDetails[0].minimum_shopping"));
        assertEquals(maximum_discount, jsonPath.getInt("couponDetails[0].maximum_discount"));
        assertEquals(created_by, jsonPath.getInt("couponDetails[0].created_by"));
        assertEquals(updated_by, jsonPath.getInt("couponDetails[0].updated_by"));
        assertEquals(is_expire, jsonPath.getInt("couponDetails[0].is_expire"));
        assertEquals(is_multiple_buy, jsonPath.getInt("couponDetails[0].is_multiple_buy"));
        assertNull(jsonPath.get("couponDetails[0].multiple_buy_limit"));
        assertEquals(created_at, jsonPath.getString("couponDetails[0].created_at"));
        assertEquals(updated_at, jsonPath.getString("couponDetails[0].updated_at"));
    }

    // Doruk US35 - TC01
    @Given("The api user prepares a PATCH request containing the address information to send to the api customerAddressUpdate endpoint.")
    public void the_api_user_prepares_a_patch_request_containing_the_address_information_to_send_to_the_api_customer_address_update_endpoint() {
        requestBody.put("name", faker.name().firstName());
        requestBody.put("email", faker.internet().emailAddress());
        requestBody.put("address", faker.address().fullAddress());
        requestBody.put("phone", faker.phoneNumber().cellPhone());
        requestBody.put("city", faker.address().city());
        requestBody.put("state", faker.address().state());
        requestBody.put("country", faker.address().country());
        requestBody.put("postal_code", faker.address().zipCode());
        requestBody.put("address_type", "home");
    }

    @Given("The api user sends the PATCH request and saves the response returned from the api customerAddressUpdate endpoint.")
    public void the_api_user_sends_the_patch_request_and_saves_the_response_returned_from_the_api_customer_address_update_endpoint() {
        API_Methods.patchResponse(requestBody.toString());
    }

    @Given("The api user verifies that the updated id information in the response body is {int}")
    public void the_api_user_verifies_that_the_id_information_in_the_response_body_is(int id) {
        jsonPath = API_Methods.response.jsonPath();
        assertEquals(id, jsonPath.getInt("updated_Id"));
    }

    // Doruk US35 - TC04
    @Given("The api user prepares a PATCH request containing the address information with incorrect email format to send to the api customerAddressUpdate endpoint.")
    public void the_api_user_prepares_a_patch_request_containing_the_address_information_with_incorrect_email_format_to_send_to_the_api_customer_address_update_endpoint() {
        faker = new Faker();
        requestBody = new JSONObject();
        requestBody.put("name", faker.name().firstName());
        requestBody.put("email", "incorrectEmailFormat");
        requestBody.put("address", faker.address().fullAddress());
        requestBody.put("phone", faker.phoneNumber().cellPhone());
        requestBody.put("city", faker.address().city());
        requestBody.put("state", faker.address().state());
        requestBody.put("country", faker.address().country());
        requestBody.put("postal_code", faker.address().zipCode());
        requestBody.put("address_type", "home");
    }

    // Doruk US36 - TC01
    @Given("The api user prepares a DELETE request containing {int} address id to send to the api customerDeleteAddress endpoint.")
    public void the_api_user_prepares_a_delete_request_containing_the_address_id_to_send_to_the_api_customer_delete_address_endpoint(int addressId) {
        requestBody = new JSONObject();
        requestBody.put("id", addressId);
    }

    @Given("The api user verifies that the deleted id information in the response body is {int}")
    public void the_api_user_verifies_that_the_deleted_id_information_in_the_response_body_is(int addressId) {
        jsonPath = API_Methods.response.jsonPath();
        assertEquals(addressId, jsonPath.getInt("Deleted_Id"));
    }

  
  //======================================================================================================================================================================
    // Azim Kaya
    @Given("The api user prepares a POST request containing the {string} information to send to the api refundReasonAdd endpoint.")
    public void the_api_user_prepares_a_post_request_containing_the_information_to_send_to_the_api_refund_reason_add_endpoint(String reason) {
    reqBody=new HashMap<>();
    reqBody.put("reason",reason);
    }
    @Given("The api user sends the POST request and saves the response returned from the api refundReasonAdd endpoint.")
    public void the_api_user_sends_the_post_request_and_saves_the_response_returned_from_the_api_refund_reason_add_endpoint() {
     API_Methods.postResponse(reqBody);
    }
    @Given("The api user prepares a PATCH request body for couponUpdate.")
    public void the_api_user_sends_the_post_request_and_sav() {
        requestBody.put("title","can");
        requestBody.put("coupon_code","attemt");
        requestBody.put("coupon_type",2);
        requestBody.put("start_date","2021-11-17");
        requestBody.put("end_date","2021-11-19");
        requestBody.put("discount",10);
        requestBody.put("discount_type",0);
        requestBody.put("minimum_shopping",1);
        requestBody.put("maximum_discount",nullValue());
        requestBody.put("is_expire",0);
        requestBody.put("is_multiple_buy",1);
    }
    @Given("The API user sends a PATCH request and records the response.")
    public void the_apı_user_sends_a_patch_request_and_records_the_response() {
        API_Methods.patchResponse(requestBody.toString());
    }
    //US31 -TC01
    @Given("The api user prepares a DELETE  request containing the id = {int} for which details are to be accessed, to send to the api endpoint.")
    public void the_api_user_prepares_a_delete_request_containing_the_id_for_which_details_are_to_be_accessed_to_send_to_the_api_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }

    @Given("The API user saves the response from the api couponDelete endpoint, verifying that the status code is {string} and the reason phrase is Unauthorized.")
    public void the_apı_user_saves_the_response_from_the_api_coupon_delete_endpoint_verifying_that_the_status_code_is_and_the_reason_phrase_is_unauthorized(String string) {
        Assert.assertTrue(API_Methods.tryCatchDelete(requestBody.toString()).equals(ConfigReader.getProperty("api","unauthorizedExceptionMessage")));
    }


//======================================================================================================================================================================================
//ihsan
    @Given("The api user verifies the content of the data {int}, {string}, {string}, {int}, {string}, {int}, {int}, {string}, {int}, {string}, {string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_id_in_the_response_body(int id , String first_name, String last_name, int role_id, String email, int is_verified, int is_active, String lang_code, int currency_id, String currency_code, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(id, jsonPath.getInt("user.id"));
        assertEquals(first_name, jsonPath.getString("user.first_name"));
        assertEquals(last_name, jsonPath.getString("user.last_name"));
        assertEquals(role_id, jsonPath.getInt("user.role_id"));
        assertEquals(email, jsonPath.getString("user.email"));
        assertEquals(is_verified, jsonPath.getInt("user.is_verified"));
        assertEquals(is_active, jsonPath.getInt("user.is_active"));
        assertEquals(lang_code, jsonPath.getString("user.lang_code"));
        assertEquals(currency_id, jsonPath.getInt("user.currency_id"));
        assertEquals(currency_code, jsonPath.getString("user.currency_code"));
        assertEquals(name, jsonPath.getString("user.name"));
    }

    @Given("In the response body for the FAQ with id = {int} should be validated, including the {string} information.")
    public void in_the_response_body_for_the_faq_with_id_should_be_validated_including_the_information(Integer int1, String title) {
       jsonPath = API_Methods.response.jsonPath();
       assertEquals(title, jsonPath.getString("Faqs[0].title"));
    }

    @Given("The api user prepares a POST request body for address-store.")
    public void the_api_user_prepares_a_post_request_body_for_address_store() {
        requestBody.put("name", faker.name());
        requestBody.put("email", faker.internet().emailAddress());
        requestBody.put("address", faker.address());
        requestBody.put("phone", "5555");
        requestBody.put("city", faker.address().city());
        requestBody.put("state", faker.address().state());
        requestBody.put("country", faker.address().country());
        requestBody.put("postal_code", "55555");
        requestBody.put("address_type", "home");
    }

    @And("The api user prepares a invalid POST request body for address-store.")
    public void theApiUserPreparesAInvalidPOSTRequestBodyForAddressStore() {
        requestBody.put("name", faker.name());
        requestBody.put("email", "wrong");
        requestBody.put("address", faker.address());
        requestBody.put("phone", "5555");
        requestBody.put("city", faker.address().city());
        requestBody.put("state", faker.address().state());
        requestBody.put("country", faker.address().country());
        requestBody.put("postal_code", "55555");
        requestBody.put("address_type", "home");
    }
    @Given("The api user prepares a POST request body {int}{string}{string}{string}{string}{string}{string}{string}{string}{string} for addressAdd.")
    public void the_api_user_prepares_a_post_request_body_for_address_add(int int01, String string01, String string02, String string03, String string04, String string05, String string06, String string07, String string08, String string09) {
        requestBody.put("customer_id", int01);
        requestBody.put("name", string01);
        requestBody.put("email", string02);
        requestBody.put("address", string03);
        requestBody.put("phone", string04);
        requestBody.put("city", string05);
        requestBody.put("state", string06);
        requestBody.put("country", string07);
        requestBody.put("postal_code", string08);
        requestBody.put("address_type", string09);
    }

}
