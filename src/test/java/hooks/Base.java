package hooks;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import java.util.Random;

import static stepdefinitions.API_Stepdefinitions.requestBody;
import static stepdefinitions.API_Stepdefinitions.faker;
import static stepdefinitions.API_Stepdefinitions.random;

public abstract class Base {
    public Base(){
    }

    public static void initialize(){
      requestBody = new JSONObject();
      faker = new Faker();
      random = new Random();
    }
}
