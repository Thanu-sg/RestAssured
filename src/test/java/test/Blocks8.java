package test;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Blocks8 {
	
	Properties prop = new Properties();
	@Test
	public void BlockPost() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\intern 17\\eclipse-workspace\\RestAutomation\\src\\main\\java\\Resource\\data.properties");
		prop.load(fis);
		
		RestAssured.baseURI= "https://api.twitter.com/1.1/blocks/";
		Response res = given().auth().oauth(prop.getProperty("CONSUMERKEY"), prop.getProperty("CONSUMERSECRET") , prop.getProperty("ACCESSTOKEN") , prop.getProperty("TOKENSECRET")).
				queryParam("screen_name","Deepitha18").
				when().post("/create.json").then().extract().response();
		
		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String id = js.get("id").toString();
		System.out.println(id);
		String name = js.get("name").toString();
		System.out.println(name);

}
}
