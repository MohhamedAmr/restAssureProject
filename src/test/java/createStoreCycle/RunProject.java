package createStoreCycle;

import static org.hamcrest.MatcherAssert.assertThat;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pojo.BodyPath;
import pojo.DeserlizeElements;
import steps.CreateStoreSteps;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RunProject {
    @Test
    public static String loginWithPartner(){
BodyPath body = new BodyPath("muhamed.elsarky@gmail.com ","12345678");
       Response response = given().baseUri("https://api-dev.shgardi.app")
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/identity/api/2/StoreManagement/Partner/Login")
                .then().log().all().extract().response();
       //DeserlizeElements tok = response.body().as(DeserlizeElements.class);
       assertThat(response.statusCode(),equalTo(200));

      return response.getBody().jsonPath().getString("response.accessToken");


    }
    @Test
    public static String CreateNewStoreID(){
        Faker faker = new Faker();
        BodyPath body = new BodyPath("12345678", faker.internet().emailAddress(), true, faker.name().lastName(), faker.name().lastName(), "12345678", faker.numerify("+2012########"), "", "", "https://dev.cdn.shgardi.app/catalog/StoreLogoImages/4f703f47-14f7-4b8d-b708-5a7b409e7489_2022-06-20_09-56-41-AM.jpg", 5);




        Response response = given().baseUri("https://api-dev.shgardi.app")
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body(body)
                .auth().oauth2(loginWithPartner())
                //.auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIrMjAxMjcxMDIyMjc5LTQiLCJqdGkiOiIwY2UxMGZlNS1mNjk4LTRhMzgtOTZlNS0xY2I4ZGM1MzgzNmYiLCJVc2VyTmFtZSI6IisyMDEyNzEwMjIyNzktNCIsIlVzZXJJZCI6IjhiNTVkYmUwLTRjYmYtNGY4Zi04Yjg0LTkzOTQ2MTM1Nzg5MiIsIlVzZXJUeXBlIjoiNCIsIlVzZXJMYW5ndWFnZSI6ImVuLVVTIiwiUGhvbmVOdW1iZXIiOiIrMjAxMjcxMDIyMjc5IiwiQ29tcGxldGVkUHJvZmlsZSI6IlRydWUiLCJIYXNQYXNzd29yZCI6IlRydWUiLCJTdG9yZU5hbWUiOiJLRkMiLCJQYXJ0bmVySWQiOiI4YjU1ZGJlMC00Y2JmLTRmOGYtOGI4NC05Mzk0NjEzNTc4OTIiLCJJc0ludGVncmF0aW9uUGFydG5lciI6IkZhbHNlIiwiTmF0aW9uYWxJZCI6IiIsIm5iZiI6MTY3NTE4NzM1NiwiZXhwIjoxNjc1MjczNzU2LCJpc3MiOiJodHRwOi8vc3RhZ2UubmFzaG1pLmNvLyIsImF1ZCI6Imh0dHA6Ly9zdGFnZS5uYXNobWkuY28vIn0.sIeIEdUBfTq8kh16fFzhwSOiAwJrpUkLr52HU_NELUI")
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/identity/api/2/StoreManagement/Stores/CreateStoreUser")
                .then().log().all().extract().response();
       // BodyPath ID = response.body().as(BodyPath.class);
        assertThat(response.statusCode(),equalTo(200));

        return response.getBody().jsonPath().getString("response.id");


    }
    @Test
    public void CreateStore() throws IOException, ParseException {

        Faker faker = new Faker();


        File file = new File("src/test/resources/CreateNewStore3.json");

        String id = CreateNewStoreID();

        JSONObject json1 = data.GetJson.readAsJASONObject("CreateNewStore3.json");
        json1.put("id" , id );
        json1.put("code" ,faker.numerify("2###")) ;
        given().baseUri("https://api-dev.shgardi.app")
                //.auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIrMjAxMjcxMDIyMjc5LTQiLCJqdGkiOiIwY2UxMGZlNS1mNjk4LTRhMzgtOTZlNS0xY2I4ZGM1MzgzNmYiLCJVc2VyTmFtZSI6IisyMDEyNzEwMjIyNzktNCIsIlVzZXJJZCI6IjhiNTVkYmUwLTRjYmYtNGY4Zi04Yjg0LTkzOTQ2MTM1Nzg5MiIsIlVzZXJUeXBlIjoiNCIsIlVzZXJMYW5ndWFnZSI6ImVuLVVTIiwiUGhvbmVOdW1iZXIiOiIrMjAxMjcxMDIyMjc5IiwiQ29tcGxldGVkUHJvZmlsZSI6IlRydWUiLCJIYXNQYXNzd29yZCI6IlRydWUiLCJTdG9yZU5hbWUiOiJLRkMiLCJQYXJ0bmVySWQiOiI4YjU1ZGJlMC00Y2JmLTRmOGYtOGI4NC05Mzk0NjEzNTc4OTIiLCJJc0ludGVncmF0aW9uUGFydG5lciI6IkZhbHNlIiwiTmF0aW9uYWxJZCI6IiIsIm5iZiI6MTY3NTE4NzM1NiwiZXhwIjoxNjc1MjczNzU2LCJpc3MiOiJodHRwOi8vc3RhZ2UubmFzaG1pLmNvLyIsImF1ZCI6Imh0dHA6Ly9zdGFnZS5uYXNobWkuY28vIn0.sIeIEdUBfTq8kh16fFzhwSOiAwJrpUkLr52HU_NELUI")
                .headers("Accept-Language", "en-US", "CountryId", 2)
                .body(file)
                .body(json1)
                .contentType(ContentType.JSON)
                .log().all()
                .when().post("/catalog/api/1/StoreDashboard/Create")
                .then().log().all().assertThat().statusCode(200);


    }

}
