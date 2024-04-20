package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.DB_Utilities.DBUtils;

import java.sql.SQLException;

public class DB_Common_Stepdefinitions {
    @Given("Establish a database connection.")
    public void establish_a_database_connection() {
        DBUtils.createConnection();
    }
    @Given("Close the database connection.")
    public void close_the_database_connection() throws SQLException {
        DBUtils.closeConnection();
    }
}
