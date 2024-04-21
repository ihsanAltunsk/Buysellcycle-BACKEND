#Reporter : Doruk Özgen
#US Priority : MEDIUM
  Feature: transactions
    Scenario: list data in the transactions table that has a unique description and has both 'Stripe' and 'Cash On Delivery' payment methods
      * Establish a database connection.
      * Close the database connection.