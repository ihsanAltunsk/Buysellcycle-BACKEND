package stepdefinitions;

import config_Requirements.ConfigReader;
import hooks.HooksAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import org.checkerframework.checker.units.qual.A;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.Pojo;
import utilities.API_Utilities.API_Methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class API_Stepdefinitions {

    public static int id;
    public static String fullPath;
    JSONObject requestBody;
    JsonPath jsonPath;
    HashMap<String, Object> reqBody;
    Pojo requestPojo;

    //Reyyan US08-TC01
    @Given("The api user prepares a GET request containing the holiday {int} for which details are to be accessed, to send to the api holidayDetails endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_holiday_for_which_details_are_to_be_accessed_to_send_to_the_api_holiday_details_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);

    }
    @Given("The api user sends a GET request and saves the response returned from the api holidayDetails endpoint.")
    public void the_api_user_sends_a_get_request_and_saves_the_response_returned_from_the_api_holiday_details_endpoint() {
        API_Methods.getBodyResponse(requestBody.toString());
    }
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
    //Reyyan US08-TC02
    @Given("The api user prepares a GET request containing the holiday <id> for which details are to be accessed, to send to the api holidayDetails endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_holiday_id_for_which_details_are_to_be_accessed_to_send_to_the_api_holiday_details_endpoint() {
        requestBody = new JSONObject();
        requestBody.put("id", id);

    }
    @Given("The API user records the response from the api holidayDetails endpoint, verifying that the status code is {string} and the holiday Not Found.")
    public void the_apı_user_records_the_response_from_the_api_holiday_details_endpoint_verifying_that_the_status_code_is_and_the_holiday_not_found(String string) {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("api", "notFoundExceptionMessage")));
    }
    //Reyyan US08-TC03
    @Given("The api user prepares a GET request containing the holidayDetails {int} for which details are to be accessed, to send to the api holidayDetails endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_holiday_details_for_which_details_are_to_be_accessed_to_send_to_the_api_holiday_details_endpoint(Integer int1) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }
    @Given("The API user records the response from the api holidayDetails endpoint, confirming that the status code is {string} and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_holiday_details_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized(String string) {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("api", "unauthorizedExceptionMessage")));
    }
    //Reyyan US18-TC01
    @Given("The api user prepares a GET request containing the refund&reason {int} for which details are to be accessed, to send to the api refundReasonDetails endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_refund_reason_for_which_details_are_to_be_accessed_to_send_to_the_api_refund_reason_details_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }
    @Given("The api user sends a GET request and saves the response returned from the api refundReasonDetails endpoint.")
    public void the_api_user_sends_a_get_request_and_saves_the_response_returned_from_the_api_refund_reason_details_endpoint() {
        API_Methods.getBodyResponse(requestBody.toString());
    }

    @Given("The api user verifies the content of the data {int}, {string},{string},{string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(int id, String reason, String created_at, String updated_at) {
        jsonPath = API_Methods.response.jsonPath();

        Assert.assertEquals(id,jsonPath.getInt("refundReasonDetails[0].id"));
        Assert.assertEquals(reason,jsonPath.getString("refundReasonDetails[0].reason"));
        Assert.assertEquals(created_at,jsonPath.getString("refundReasonDetails[0].created_at"));
        Assert.assertEquals(updated_at,jsonPath.getString("refundReasonDetails[0].updated_at"));
    }
    //Reyyan US18-TC02
    @Given("The api user prepares a GET request containing the refund&reason {int} for which details are to be accessed, to send to the api refundReasonDetails  endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_refund_reason_for_which_details_are_to_be_accessed_to_send_to_the_api_refund_reason_details_endpoint(Integer id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);

    }
    @Given("The API user records the response from the api refundReasonDetails  endpoint, verifying that the status code is {string} and the holiday Not Found.")
    public void the_apı_user_records_the_response_from_the_api_refund_reason_details_endpoint_verifying_that_the_status_code_is_and_the_holiday_not_found(String message) {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("api", "notFoundExceptionMessage")));
    }
    //Reyyan US18-TC03
    @Given("The API user records the response from the api refundReasonDetails  endpoint, confirming that the status code is {string} and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_refund_reason_details_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized(String message) {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("api", "unauthorizedExceptionMessage")));

    }
    //Reyyan US22-TC01
    @Given("The api user prepares a GET request containing the department with {int} for which details are to be accessed, to send to the api departmentList  endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_department_with_id_for_which_details_are_to_be_accessed_to_send_to_the_api_department_list_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }
    @Given("The api user sends a GET request and saves the response returned from the api departmentList  endpoint.")
    public void the_api_user_sends_a_get_request_and_saves_the_response_returned_from_the_api_department_list_endpoint() {
        API_Methods.getBodyResponse(requestBody.toString());
    }
    @Given("The api user verifies the content of the data {string},{string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(String name, String details) {
        jsonPath = API_Methods.response.jsonPath();
        Assert.assertEquals(name,jsonPath.getString("departments[0].name"));
        Assert.assertEquals(details,jsonPath.getString("departments[0].details"));

    }
    //Reyyan US22-TC02

    @Given("The api user prepares a GET request containing the department with {int} for which details are to be accessed, to send to the api departmentList endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_department_with_for_which_details_are_to_be_accessed_to_send_to_the_api_department_list_endpoint(Integer int1) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }
    @Given("The API user records the response from the api departmentList  endpoint, confirming that the status code is {string} and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_department_list_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized(String string) {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("api", "unauthorizedExceptionMessage")));
    }
    //Reyyan US29-TC01

    @Given("The api user prepares a POST request containing the {string}, {string}, {int}, {string}, {string}, {int}, {int}, {int}, null, {int}, {int} information to send to the api couponAdd endpoint.")
    public void the_api_user_prepares_a_post_request_containing_the_null_information_to_send_to_the_api_coupon_add_endpoint(String title, String coupon_code, int coupon_type, String start_date, String end_date, int discount, int discount_type, int minimum_shopping, int is_expire, int is_multiple_buy) {
        requestBody = new JSONObject();
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
    @Given("The api user sends the POST request and saves the response returned from the api couponAdd endpoint.")
    public void the_api_user_sends_the_post_request_and_saves_the_response_returned_from_the_api_coupon_add_endpoint() {

        API_Methods.postResponse(requestBody.toString());
    }
    //Reyyan SS29-TC02
    @Given("The api user prepares a GET request containing the refund reason {int} for which details are to be accessed, to send to the api couponDetails endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_refund_reason_for_which_details_are_to_be_accessed_to_send_to_the_api_coupon_details_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id",id);
    }
    @Given("The api user sends a GET request and saves the response returned from the api couponDetails endpoint.")
    public void the_api_user_sends_a_get_request_and_saves_the_response_returned_from_the_api_coupon_details_endpoint() {
        API_Methods.getBodyResponse(requestBody.toString());
    }

// ===============================================================================================================================================================================
    //Humeyra Tayfun
    @Given("The API user sends a GET request and records the response from the api refundReasonList endpoint.")
    public void the_apı_user_sends_a_get_request_and_records_the_response_from_the_api_refund_reason_list_endpoint() {
            API_Methods.getResponse();
    }

    @Given("The api user validates the {string} of the response body with index {int}.")
    public void the_api_user_validates_the_of_the_response_body_with_index(String reason, Integer dataIndex) {
       API_Methods.response.then()
               .assertThat()
               .body("refundReason["+ dataIndex+ "].reason",equalTo(reason));
    }

    @Given("The API user records the response from the api refundReasonList endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_refund_reason_list_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized() {
        Assert.assertTrue(API_Methods.tryCatchGet().equals(ConfigReader.getProperty("api","unauthorizedExceptionMessage")));

    }

    @Given("The api user prepares a PATCH request containing the {string} data to send to the api refundReasonUpdate endpoint.")
    public void the_api_user_prepares_a_patch_request_containing_the_data_to_send_to_the_api_refund_reason_update_endpoint(String reason) {
        requestBody=new JSONObject();
        requestBody.put("reason",reason);
    }
    @Given("The api user sends the PATCH request and saves the response returned from the api refundReasonUpdate endpoint.")
    public void the_api_user_sends_the_patch_request_and_saves_the_response_returned_from_the_api_refund_reason_update_endpoint() {
        API_Methods.patchResponse(requestBody.toString());

    }
    @Given("The api user verifies that the updated id information in the response body matches the id path parameter specified in the endpoint.")
    public void the_api_user_verifies_that_the_updated_id_information_in_the_response_body_matches_the_id_path_parameter_specified_in_the_endpoint() {
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
  //===================================================================================================================
    // Senayda US05-TC02
    @Given("The api user verifies the content of the data {int}, {string}, {string}, {string}, {string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(Integer id, String first_name, String username, String email, String name) {
    
    }

    @Given("The API user sends a GET request {int} and records the response from the api faq details endpoint.")
    public void the_api_user_sends_a_get_request_and_records_the_response_from_the_api_faq_details_endpoint(int id) {
        requestBody.put("id",id);
        API_Methods.getBodyResponse(requestBody.toString());
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
    //======================================================================================================================================================================
    // Doruk US23 - TC01
    @Given("The api user prepares a GET request containing the {int} information to send to the api departmanDetails endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_information_to_send_to_the_api_departman_details_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }

    @Given("The api user sends the GET request and saves the response returned from the api departmanDetails endpoint.")
    public void the_api_user_sends_the_get_request_and_saves_the_response_returned_from_the_api_departman_details_endpoint() {
        API_Methods.getBodyResponse(requestBody.toString());
    }

    @Given("The api user prepares a POST request containing the department information to send to the api departmanAdd endpoint.")
    public void the_api_user_prepares_a_post_request_containing_the_department_information_to_send_to_the_api_departman_add_endpoint(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        System.out.println(rows);

        requestBody = new JSONObject();
        requestBody.put(rows.get(0).get(0), rows.get(1).get(0));
        requestBody.put(rows.get(0).get(1), rows.get(1).get(1));
        requestBody.put(rows.get(0).get(2), rows.get(1).get(2));
    }

    @Given("The api user sends the POST request and saves the response returned from the api departmanDetails endpoint.")
    public void the_api_user_sends_the_post_request_and_saves_the_response_returned_from_the_api_departman_details_endpoint() {
        API_Methods.postResponse(requestBody.toString());
    }

    @Given("The api user prepares a GET request to send to the api couponList endpoint.")
    public void the_api_user_prepares_a_get_request_to_send_to_the_api_coupon_list_endpoint() {
        requestBody = new JSONObject();
    }

    @Given("The api user sends the GET request and saves the response returned from the api couponList endpoint.")
    public void the_api_user_sends_the_get_request_and_saves_the_response_returned_from_the_api_coupon_list_endpoint() {
        API_Methods.getResponse();
    }
}
