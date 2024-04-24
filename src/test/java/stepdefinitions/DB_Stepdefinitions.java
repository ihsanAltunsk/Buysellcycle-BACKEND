package stepdefinitions;

import config_Requirements.ConfigReader;
import hooks.Base;
import io.cucumber.java.en.Given;
import utilities.DB_Utilities.DBUtils;
import utilities.DB_Utilities.DB_InsertInto_Methods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static utilities.DB_Utilities.DBUtils.getStatement;

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

    // senayda

    @Given("Query01 Prepare and execute the query.")
    public void query01_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQueryUS01Q01();
        preparedStatement = DBUtils.getConnection().prepareStatement(query);
        preparedStatement.setString(1,ConfigReader.getProperty("db", "categoryName"));
       resultSet= preparedStatement.executeQuery();


    }
    @Given("Verify the {string} information Results are obtained.")
    public void verify_the_information_results_are_obtained(String categoryName) throws SQLException {

        resultSet.next();
        categoryName=resultSet.getString(categoryName);
        String expectedName = ConfigReader.getProperty("db","categoryName");
        assertEquals(expectedName, categoryName);
    }

    @Given("Query08 Prepare and execute the query.")
    public void query08_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQueryUS08Q01();
        preparedStatement = DBUtils.getConnection().prepareStatement(query);
    }

    @Given("Process the results for verify.")
    public void process_the_results_for_verify() throws SQLException {

        List<String> expectedDelivery_Process = new ArrayList<>(5);
        preparedStatement.setInt(1,5);
        resultSet= preparedStatement.executeQuery();

        expectedDelivery_Process.add("Delivered");
        expectedDelivery_Process.add("Recieved");
        expectedDelivery_Process.add("Shipped");
        expectedDelivery_Process.add("Processing");
        expectedDelivery_Process.add("Pending");

        for (int i = 0; i < 5; i++) {
            resultSet.next();
            assertEquals(expectedDelivery_Process.get(i),resultSet.getString("name"));
        }

    }
    @Given("Query015 Prepare and execute the query.")
    public void query015_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQueryUS15Q01();
        preparedStatement = DBUtils.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,3);
        resultSet= preparedStatement.executeQuery();
    }

    // ======================================================================================
}
