package hooks;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

public abstract class Base {
    public static String fullPath;
    public static JSONObject requestBody;
    public static Random random;
    public static JsonPath jsonPath;
    public static Faker faker;
    public static HashMap<String, Object> reqBodyMap;
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static String query;

    public static void initialize(){
      requestBody = new JSONObject();
      faker = new Faker();
      random = new Random();
      reqBodyMap=new HashMap<>();
    }
}
