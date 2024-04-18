package stepdefinitions;

import com.github.javafaker.Faker;
import config_Requirements.ConfigReader;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.Pojo;
import utilities.API_Utilities.API_Methods;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class API_Stepdefinitions {

    public static int id;
    public static String fullPath;
    JSONObject requestBody;
    JsonPath jsonPath;
    HashMap<String, Object> reqBody;
    Pojo requestPojo;
    Faker faker;

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

    @Given("The api user validates the {string} of the response body with index {int}.")
    public void the_api_user_validates_the_of_the_response_body_with_index(String reason, Integer dataIndex) {
       API_Methods.response.then()
               .assertThat()
               .body("refundReason["+ dataIndex+ "].reason",equalTo(reason));
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
// ===============================================================================================================================================================================
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
        requestBody.put("phone", faker.phoneNumber());
        requestBody.put("city", faker.address().city());
        requestBody.put("state", faker.address().state());
        requestBody.put("country", faker.address().country());
        requestBody.put("postal_code", faker.address().zipCode());
        requestBody.put("address_type", "home");
    }
// ===============================================================================================================================================================================

}
