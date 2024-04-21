#Reporter : Azim Kaya
#US Priority : MEDIUM
  Feature: contacts
    Scenario: Add a data containing (id,name,email,query_type,message) information in the contacts table.
              Delete the added data by entering the email information in the contacts table.
              Verify that it has been deleted.
      * Establish a database connection.
      * Close the database connection.