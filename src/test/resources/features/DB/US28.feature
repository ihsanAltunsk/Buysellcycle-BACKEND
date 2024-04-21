#Reporter : Reyyan Mert
#US Priority : LOW
  Feature: support_tickets
    Scenario: In the support_tickets table, list the unique user_ids of the data with and without '-' in reference_no.
      * Establish a database connection.
      * Close the database connection.