package stepdefinitions;

import config_Requirements.ConfigReader;
import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.API_Utilities.API_Methods;

public class API_Common_Stepdefinitions {
    JSONObject requestBody;

    @Given("The api user constructs the base url with the {string} token.")
    public void the_api_user_constructs_the_base_url_with_the_token(String token) {
        HooksAPI.setUpApi(token);
    }
    @Given("The api user sets {string} path parameters")
    public void the_api_user_sets_path_parameters(String rawPaths) {
        API_Methods.setParameters(rawPaths);
    }
    @Given("The api user verifies that the status code is {int}")
    public void the_api_user_verifies_that_the_status_code_is(int code) {
        API_Methods.statusCodeAssert(code);
    }
    @Given("The api user verifies that the message information in the response body is {string}")
    public void the_api_user_verifies_that_the_message_information_in_the_response_body_is(String message) {
        API_Methods.messageAssert(message);
    }
    @Given("The API user sends a GET request and records the response.")
    public void the_apı_user_sends_a_get_request_and_records_the_response() {
        API_Methods.getResponse();
    }
    @Given("The API user records the response from the api endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized() {
        Assert.assertTrue(API_Methods.tryCatchGet().equals(ConfigReader.getProperty("api","unauthorizedExceptionMessage")));
    }
    @Given("The api user prepares a GETBODY request containing the id = {int} for which details are to be accessed, to send to the api endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_refund_reason_id_for_which_details_are_to_be_accessed_to_send_to_the_api_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }
    @Given("The API user sends a GETBODY request and records the response.")
    public void the_api_user_sends_a_get_request_and_saves_the_response_returned_from_the_api_refund_reason_details_endpoint() {
        API_Methods.getBodyResponse(requestBody.toString());
    }
    @Given("The API user sends a POST request and records the response.")
    public void the_api_user_sends_a_post_request_and_records_the_response() {
        API_Methods.postResponse(requestBody.toString());
    }



}
