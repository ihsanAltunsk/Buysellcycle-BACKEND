#Reporter : İhsan Altunışık
#US Priority : LOW
  Feature: log_activity
    Scenario: In the log_activity table, calculate and verify the number of topics with ip='46.2.239.35' and method='Delete'.
      * Establish a database connection.
      * Query09 Prepare and execute the query.
      * Process the results for counting
      * Close the database connection.