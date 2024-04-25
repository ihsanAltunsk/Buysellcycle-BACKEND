#Reporter : Azim Kaya
#US Priority : MEDIUM
  Feature: attendances
    Scenario: List the unique 'notes' in the attendances table, separated by days.
      * Establish a database connection.
      * list the unique 'notes' in the attendances table.
      * Close the database connection.