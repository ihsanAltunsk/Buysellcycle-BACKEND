package manage;

public class Manage {
// ============================================QUERY LIST============================================
    private String queryUS01Q01 = "select name from categories where slug=?";
    private String queryUS02Q01 = "INSERT INTO cities (id, name, state_id, status, created_at) VALUES(?, ?, ?, ?, ?)";
    private String queryUS02Q02 = "SELECT id FROM cities";
    private String queryUS03Q01 ="delete from cities where id=? and name=?";
    private String queryUS04Q01 = "";
    private String queryUS05Q01 = "INSERT INTO contacts (id,name,email,query_type,message) VALUES(?, ?, ?, ?, ?)";
    private String queryUS05Q02 = "DELETE FROM contacts WHERE email =?";
    private String queryUS06Q01 = "";
    private String queryUS07Q01 = "select phone from customer_addresses limit 3";
    private String queryUS08Q01 = "SELECT name FROM delivery_processes ORDER BY id DESC LIMIT ?";
    private String queryUS09Q01 = "SELECT COUNT(id) AS total_amount FROM log_activity WHERE ip = ? AND method = ?";
    private String queryUS10Q01 = "select customer_id from order_address_details where shipping_address != billing_address";
    private String queryUS11Q01 = "";
    private String queryUS12Q01 = "";
    private String queryUS13Q01 = "";
    private String queryUS14Q01 = "SELECT * FROM refund_reasons WHERE reason IS NULL";
    private String queryUS15Q01 = "select * from customer_coupon_stores limit ?";
    private String queryUS16Q01 = "";
    private String queryUS17Q01 = "select attendances.year,users.email from attendances join users on attendances.id=users.id where attendances.year<? and users.id=?";
    private String queryUS18Q01 = "";
    private String queryUS19Q01 = "UPDATE bank_accounts  SET opening_balance=? WHERE bank_name=?";
    private String queryUS20Q01 = "";
    private String queryUS21Q01 = "select * from guest_order_details";
    private String queryUS21Q02 = "UPDATE guest_order_details SET shipping_name = 'Reyyan' WHERE order_id = 118";
    private String queryUS22Q01 = "insert into digital_gift_cards (gift_name,descriptionOne) value (?,?)";
    private String queryUS22Q02= "delete from digital_gift_cards where id=?";
    private String queryUS23Q01 = "";
    private String queryUS24Q01 = "select order_number from orders where not customer_email=? and sub_total<? order by order_number desc";
    private String queryUS25Q01 = "";
    private String queryUS26Q01 = "";
    private String queryUS27Q01 = "";
    private String queryUS28Q01 = "";
    private String queryUS29Q01 = "";
    private String queryUS30Q01 = "";

// ============================================GETTER LIST============================================
    public String getQueryUS01Q01() {
    return queryUS01Q01;
}
    public String getQueryUS02Q01() {
        return queryUS02Q01;
    }
    public String getQueryUS02Q02() {
        return queryUS02Q02;
    }
    public String getQueryUS03Q01() {
        return queryUS03Q01;
    }
    public String getQueryUS04Q01() {
        return queryUS04Q01;
    }
    public String getQueryUS05Q01() {
        return queryUS05Q01;
    }
    public String getQueryUS05Q02() {
        return queryUS05Q02;
    }
    public String getQueryUS06Q01() {
        return queryUS06Q01;
    }
    public String getQueryUS07Q01() {
        return queryUS07Q01;
    }
    public String getQueryUS08Q01() {
        return queryUS08Q01;
    }
    public String getQueryUS09Q01() {
        return queryUS09Q01;
    }
    public String getQueryUS10Q01() {
        return queryUS10Q01;
    }
    public String getQueryUS11Q01() {
        return queryUS11Q01;
    }
    public String getQueryUS12Q01() {
        return queryUS12Q01;
    }
    public String getQueryUS13Q01() {
        return queryUS13Q01;
    }
    public String getQueryUS14Q01() {
        return queryUS14Q01;
    }
    public String getQueryUS15Q01() {
        return queryUS15Q01;
    }
    public String getQueryUS16Q01() {
        return queryUS16Q01;
    }
    public String getQueryUS17Q01() {
        return queryUS17Q01;
    }
    public String getQueryUS18Q01() {
        return queryUS18Q01;
    }
    public String getQueryUS19Q01() {
        return queryUS19Q01;
    }
    public String getQueryUS20Q01() {
        return queryUS20Q01;
    }
    public String getQueryUS21Q01() {
        return queryUS21Q01;
    }
    public String getQueryUS21Q02() {
        return queryUS21Q02;
    }
    public String getQueryUS22Q01() {
        return queryUS22Q01;
    }
    public String getQueryUS23Q01() {
        return queryUS23Q01;
    }
    public String getQueryUS24Q01() {
        return queryUS24Q01;
    }
    public String getQueryUS25Q01() {
        return queryUS25Q01;
    }
    public String getQueryUS26Q01() {
        return queryUS26Q01;
    }
    public String getQueryUS27Q01() {
        return queryUS27Q01;
    }
    public String getQueryUS28Q01() {
        return queryUS28Q01;
    }
    public String getQueryUS29Q01() {
        return queryUS29Q01;
    }
    public String getQueryUS30Q01() {
        return queryUS30Q01;
    }

    public String getQueryUS22Q02() {
        return queryUS22Q02;
    }
}
