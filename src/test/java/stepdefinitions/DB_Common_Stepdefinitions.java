package stepdefinitions;

import hooks.Base;
import io.cucumber.java.en.Given;
import utilities.DB_Utilities.DBUtils;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DB_Common_Stepdefinitions extends Base{
    @Given("Establish a database connection.")
    public void establish_a_database_connection() {
        Base.initialize();
        DBUtils.createConnection();
    }
    @Given("Close the database connection.")
    public void close_the_database_connection() throws SQLException {
        DBUtils.closeConnection();
    }
    @Given("Process the results for update {int}.")
    public void process_the_results_for_update(int row ) throws SQLException {
        rowCount = preparedStatement.executeUpdate();
        assertEquals(row, rowCount);
    }
}
