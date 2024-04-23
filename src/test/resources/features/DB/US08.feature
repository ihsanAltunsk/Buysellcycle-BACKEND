#Reporter : Senayda Akkaya
#US Priority : LOW
  Feature: delivery_processes
    Scenario: Verify that the first 5 data names in the delivery_processes table are in reverse order (Shipped, Recieved, Processing, Pending, Delivered).
      * Establish a database connection.
      * Query08 Prepare and execute the query.
      * Process the results for verify.
      * Close the database connection.