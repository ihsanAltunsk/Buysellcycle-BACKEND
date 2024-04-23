#Reporter : Reyyan Mert
#US Priority : MEDIUM

  Feature: refund_reasons
    Scenario: Verify whether there is data in the refund_reasons table with a 'reason' value of Null.
      * Establish a database connection.
      * Query14 Prepare and execute the query
      * Check if there is 'reason' data with null value.
      * Close the database connection.