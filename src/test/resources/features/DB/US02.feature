#Reporter : İhsan Altunışık
#US Priority : HIGH
  Feature: cities
    Scenario: Add a data containing the values (id,name,state_id,status,created_at) to the cities table.
              Verify that the data has been added from the cities table.
      * Establish a database connection.
      * Query02 Prepare and execute the query.
      * Process the results for update.
      * Close the database connection.