package test;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getQT2 {
	Properties	prop = new Properties();
	
	
	@Test
	public void GetAPI() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\intern 17\\eclipse-workspace\\RestAutomation\\src\\main\\java\\Resource\\data.properties");
		prop.load(fis);
		
		RestAssured.baseURI="https://api.twitter.com/1.1/";
		Response res = given().auth().oauth(prop.getProperty("CONSUMERKEY"), prop.getProperty("CONSUMERSECRET") , prop.getProperty("ACCESSTOKEN") , prop.getProperty("TOKENSECRET")).
				queryParam("q","#ipl2021").
				//queryParam("geocode","12.88470-77.59648 100mi").
				when().get("search/tweets.json").then().extract().response();
		
		String response = res.asPrettyString();
	
	System.out.println(response);
//		JsonPath js = new JsonPath(response);
//		List<String> abc = js.get("statuses.id") ;
//		String s=abc.toString();
//		String result=s.substring(2,s.length()-2);
//		String arr[]=result.split(",");
//		for(int i = 0;i<10;i++) {
//			System.out.println(arr[i]);
//			
//		}
//	List<String> abcd = js.get("statuses.text") ;
//		String s1=abcd.toString();
//		String result1=s1.substring(2,s1.length()-2);
//		String arr1[]=result1.split(",");
//		for(int i = 0;i<10;i++) {
//			System.out.println(arr1[i]);
//	}
	

}
}
