package stepdefinitions;

import config_Requirements.ConfigReader;
import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.Pojo;
import utilities.API_Utilities.API_Methods;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

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
        System.out.println(id);

    }
    @Given("The api user sends a GET request and saves the response returned from the api holidayDetails endpoint.")
    public void the_api_user_sends_a_get_request_and_saves_the_response_returned_from_the_api_holiday_details_endpoint() {

    }
    @Given("The api user verifies the content of the data {int}, {string}, {string}, {int}, {string},{string},{string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(int id, String year, String name, int type, String date, String created_at , String updated_at ) {


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
    //======================================================================================================================================================================
}
