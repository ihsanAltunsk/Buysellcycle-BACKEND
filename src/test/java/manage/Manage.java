package manage;

import lombok.Getter;
@Getter
public class Manage {
    private String queryUS01Q01 = "select name from categories where slug=?";
    private String queryUS02Q01 = "INSERT INTO cities (id, name, state_id, status, created_at) VALUES(?, ?, ?, ?, ?)";
    private String queryUS02Q02 = "SELECT id FROM cities";
    private String queryUS03Q01 = "delete from cities where id=? and name=?";
    private String queryUS04Q01 = "INSERT INTO contacts (id, name, email, query_type, message) VALUES (?, ?, ?, ?, ?)";
    private String queryUS04Q02 = "SELECT id FROM contacts";
    private String queryUS04Q03 = "UPDATE contacts SET message = ? WHERE id = ?;";
    private String queryUS05Q01 = "INSERT INTO contacts (id,name,email,query_type,message) VALUES(?, ?, ?, ?, ?)";
    private String queryUS05Q02 = "DELETE FROM contacts WHERE email =?";
    private String queryUS06Q01 = "";
    private String queryUS07Q01 = "select phone from customer_addresses limit 3";
    private String queryUS08Q01 = "SELECT name FROM delivery_processes ORDER BY id DESC LIMIT ?";
    private String queryUS09Q01 = "SELECT COUNT(id) AS total_amount FROM log_activity WHERE ip = ? AND method = ?";
    private String queryUS10Q01 = "select customer_id from order_address_details where shipping_address != billing_address";
    private String queryUS11Q01 = "SELECT SUM(amount) AS total_amount FROM wallet_balances WHERE type = ? AND id BETWEEN ? AND ?";
    private String queryUS12Q01 = "SELECT DISTINCT note FROM attendances";
    private String queryUS13Q01 = "";
    private String queryUS14Q01 = "SELECT * FROM refund_reasons WHERE reason IS NULL";
    private String queryUS15Q01 = "select * from customer_coupon_stores limit ?";
    private String queryUS16Q01 = "SELECT orders.id FROM order_address_details JOIN orders ON order_address_details.order_id = orders.id WHERE order_address_details.shipping_address = ?";
    private String queryUS17Q01 = "select attendances.year,users.email from attendances join users on attendances.id=users.id where attendances.year<? and users.id=?";
    private String queryUS18Q01 = "INSERT INTO bank_accounts (id, bank_name, branch_name, account_name, account_number) VALUES(?, ?, ?, ?, ?)";
    private String queryUS18Q02 = "SELECT id FROM bank_accounts";
    private String queryUS19Q01 = "UPDATE bank_accounts  SET opening_balance=? WHERE bank_name=?";
    private String queryUS20Q01 = "";
    private String queryUS21Q01 = "select * from guest_order_details";
    private String queryUS21Q02 = "UPDATE guest_order_details SET shipping_name = 'Reyyan' WHERE order_id = 118";
    private String queryUS22Q01 = "insert into digital_gift_cards (gift_name,descriptionOne) value (?,?)";
    private String queryUS22Q02= "delete from digital_gift_cards where id=?";
    private String queryUS23Q01 = "SELECT module, COUNT(*) AS type_count FROM email_template_types WHERE module IS NOT NULL GROUP BY module";
    private String queryUS24Q01 = "select order_number from orders where not customer_email=? and sub_total<? order by order_number desc";
    private String queryUS25Q01 = "SELECT txn_id, MAX(amount) AS max_amount FROM order_payments WHERE txn_id != ? GROUP BY txn_id HAVING MAX(amount) > ? ORDER BY max_amount DESC";
    private String queryUS26Q01 = "SELECT payment_method, sum(amount) AS total_amount FROM transactions GROUP BY payment_method HAVING total_amount > ? ORDER BY payment_method DESC";
    private String queryUS27Q01 = "";
    private String queryUS28Q01 = "";
    private String queryUS29Q01 = "";
    private String queryUS30Q01 = "SELECT SUM(total_price) AS total_price FROM carts WHERE is_buy_now = ? AND created_at < ?";
}
