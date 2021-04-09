package test;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Weather4 {

	Properties prop = new Properties();
	
	@Test
	public void GetAPI() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\intern 17\\eclipse-workspace\\RestAutomation\\src\\main\\java\\Resource\\data.properties");
		prop.load(fis);
		
		RestAssured.baseURI="https://api.twitter.com/1.1/";
		Response res = given().auth().oauth(prop.getProperty("CONSUMERKEY"), prop.getProperty("CONSUMERSECRET") , prop.getProperty("ACCESSTOKEN") , prop.getProperty("TOKENSECRET")).
				queryParam("q","BngWeather").
				//queryParam("geocode","20.593684%2C78.96288%2C6400m").
				when().get("search/tweets.json").then().extract().response();
		
		String response = res.prettyPrint();
	    System.out.println(response);
	
	
	
	}
}
