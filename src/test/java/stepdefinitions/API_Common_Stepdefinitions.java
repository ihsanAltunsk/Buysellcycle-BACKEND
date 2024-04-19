package stepdefinitions;

import config_Requirements.ConfigReader;
import hooks.Base;
import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.API_Utilities.API_Methods;

import static stepdefinitions.API_Stepdefinitions.requestBody;

public class API_Common_Stepdefinitions extends Base {


    @Given("The api user constructs the base url with the {string} token.")
    public void the_api_user_constructs_the_base_url_with_the_token(String token) {
        Base.initialize();
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
    @Given("The API user sends a {string} request and records the response.")
    public void the_apı_user_sends_a_get_request_and_records_the_response(String value) {
            switch (value) {
                case "GET":
                    API_Methods.getResponse();
                    break;
                case "POST":
                    API_Methods.postResponse(requestBody.toString());
                    break;
                case "PATCH":
                    API_Methods.patchResponse(requestBody.toString());
                    break;
                case "DELETE":
                    API_Methods.deleteResponse(requestBody.toString());
                    break;
                default:
                    System.out.println("Invalid Method Value");
        }
    }
    @Given("The API user records the response from the api endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized() {
        Assert.assertTrue(API_Methods.tryCatchGet().equals(ConfigReader.getProperty("api","unauthorizedExceptionMessage")));
    }
    @Given("The api user prepares a GETBODY request containing the id = {int} and records the response.")
    public void the_api_user_prepares_a_get_request_containing_the_refund_reason_id_for_which_details_are_to_be_accessed_to_send_to_the_api_endpoint(int id) {
        requestBody.put("id", id);
        API_Methods.getBodyResponse(requestBody.toString());
    }
}
