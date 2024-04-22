package stepdefinitions;

import hooks.Base;
import io.cucumber.java.en.Given;
import utilities.DB_Utilities.DB_InsertInto_Methods;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DB_Stepdefinitions extends Base {
    //ihsan
    @Given("Query02 Prepare and execute the query.")
    public void query02_prepare_and_execute_the_query() throws SQLException {
        DB_InsertInto_Methods.citiesInsert();
    }
    @Given("Query02 Process the results.")
    public void query02_process_the_results() {

    }
// ====================================================================================================================================================================

}
