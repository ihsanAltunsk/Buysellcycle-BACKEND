package stepdefinitions;

import config_Requirements.ConfigReader;
import hooks.Base;
import io.cucumber.java.en.Given;
import utilities.DB_Utilities.DBUtils;
import utilities.DB_Utilities.DB_InsertInto_Methods;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

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
    @Given("Query07 Prepare and execute the query.")
    public void query07_prepare_and_execute_the_query() throws SQLException {
        DBUtils.printFirstThreePhoneNumbers("phone");

    }
    @Given("Check if each {string} number has the number {string}")
    public void check_if_each_number_has_the_number(String phone, String number) {
        DBUtils.checkPhoneNumbersForFive();
        String expectedPhone = "5";
        String actualPhone = DBUtils.phone;
        assertTrue(actualPhone.contains("5"));
    }
    @Given("Query14 Prepare and execute the query")
    public void query14_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQueryUS14Q01();
        DBUtils.getStatement().executeQuery(query);
        List<Object> reason = DBUtils.getColumnData(query,"reason");
        assertFalse(reason.isEmpty());

    }

    @Given("Calculate the number of orders placed according to order_id in the guest_order_details table.")
    public void calculate_the_number_of_orders_placed_according_to_order_id_in_the_guest_order_details_table() throws SQLException {
        DBUtils.getOrderCounts();
    }
    @Given("Update shipping_name based on order number")
    public void update_shipping_name_based_on_order_number() throws SQLException {
        query = queryManage.getQueryUS21Q03();
        preparedStatement = DBUtils.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 118);
        preparedStatement.setString(2, "Reyyan");
        rowCount = preparedStatement.executeUpdate();
        assertEquals(1, rowCount);

    }

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
        query = queryManage.getQueryUS01Q01();
        preparedStatement = DBUtils.getConnection().prepareStatement(query);

    }

    @Given("Process the results for verify.")
    public void process_the_results_for_verify() {


    }


    // ======================================================================================
}
