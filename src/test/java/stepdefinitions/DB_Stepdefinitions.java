package stepdefinitions;

import hooks.Base;
import io.cucumber.java.en.Given;
import utilities.DB_Utilities.DBUtils;
import utilities.DB_Utilities.DB_InsertInto_Methods;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DB_Stepdefinitions extends Base {
    //ihsan
    @Given("Query02 Prepare and execute the query.")
    public void query02_prepare_and_execute_the_query() throws SQLException {
        DB_InsertInto_Methods.citiesInsert();
    }

    @Given("Query09 Prepare and execute the query.")
    public void query09_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQueryUS09Q01();
        preparedStatement = DBUtils.getConnection().prepareStatement(query);

        preparedStatement.setString(1,"46.2.239.35");
        preparedStatement.setString(2,"Delete");
        resultSet = preparedStatement.executeQuery();
    }

    @Given("Process the results for counting")
    public void process_the_results_for_counting() throws SQLException {
        resultSet.next();
        System.out.println("Total amount: " + resultSet.getLong("total_amount"));
    }
// ====================================================================================================================================================================

}
