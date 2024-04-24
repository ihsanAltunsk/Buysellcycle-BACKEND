#Reporter : Azim Kaya
#US Priority : HIGHEST
  Feature: bank_accounts
    Scenario: Verify that the opening_balance value of the data with bank_name=? in the bank_accounts table is not updated with a negative value.
      * Establish a database connection.
      * Query19 Prepare and execute the query.
      * Process the results for update 0.
      * Close the database connection.