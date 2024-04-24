#Reporter : Azim Kaya
#US Priority : MEDIUM
  Feature: contacts
    @AZ
    Scenario: Add a data containing (id,name,email,query_type,message) information in the contacts table.
              Delete the added data by entering the email information in the contacts table.
              Verify that it has been deleted.
      * Establish a database connection.
      * Query05 Prepare and execute the query.
      * Delete the added data by entering email information in the contacts table.
      * Process the results for update 1.
      * Close the database connection.
