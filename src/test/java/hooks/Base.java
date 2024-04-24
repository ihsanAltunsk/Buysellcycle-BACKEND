package hooks;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import manage.Manage;
import org.json.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class Base {
    public static String fullPath, query, name, description;
    public static String customer_email;
    public static double sub_total;
    public static int rowCount, state_id, status;
    public static long id;
    public static Date date;
    public static JSONObject requestBody;
    public static Random random;
    public static JsonPath jsonPath;
    public static Faker faker;
    public static HashMap<String, Object> reqBodyMap;
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public static Manage queryManage;

    public static void initialize(){
        requestBody = new JSONObject();
        faker = new Faker();
        random = new Random();
        reqBodyMap=new HashMap<>();
        queryManage = new Manage();
    }



}
