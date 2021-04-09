package test;



import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class ListUser5 {
	//private static Logger log = LogManager.getLogger(getTrends.class.getName());

	Properties prop = new Properties();
	
	
	@Test
	public void list() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\intern 17\\eclipse-workspace\\RestAutomation\\src\\main\\java\\Resource\\data.properties");
		prop.load(fis);
	RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
	Response res =given().auth().oauth(prop.getProperty("CONSUMERKEY"), prop.getProperty("CONSUMERSECRET") , prop.getProperty("ACCESSTOKEN") , prop.getProperty("TOKENSECRET")).
			when().queryParam("exclude_replies", "true").
			get("user_timeline.json").
	
			then().assertThat().statusCode(200).extract().response();

		String response = res.asString() ;
		JsonPath js = new JsonPath(response);
		List<String> abc = js.get("text") ;
		System.out.println(abc);
		}

}
