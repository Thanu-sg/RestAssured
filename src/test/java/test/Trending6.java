package test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
//import org.apache.logging.log4j.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Trending6 {
	String INDIA="23424848";
	String US="23424977";
    String UK="23424975";
	String ISRAEL="23424852";
	
	Properties prop = new Properties();

	//private static Logger log = LogManager.getLogger(getTrends.class.getName());

	@Test (dataProvider="getData")
	public void API_test(String location) throws IOException {
		
FileInputStream fis =new FileInputStream("C:\\Users\\intern 17\\eclipse-workspace\\RestAutomation\\src\\main\\java\\Resource\\data.properties");
prop.load(fis);
	RestAssured.baseURI="https://api.twitter.com/1.1/trends/";
	Response res =given().auth().oauth(prop.getProperty("CONSUMERKEY"), prop.getProperty("CONSUMERSECRET") , prop.getProperty("ACCESSTOKEN") , prop.getProperty("TOKENSECRET")).
		queryParam("id",location).
	when().
		get("place.json").
	then().assertThat().statusCode(200).extract().response();
	
	
	String response = res.asString() ;
	JsonPath js = new JsonPath(response);
	List<String> Res = js.get("trends.name") ;
	System.out.println(Res);
	String s=Res.toString();
	String result=s.substring(2,s.length()-2);
	String arr[]=result.split(",");
	for(int i = 0;i<10;i++) {
		System.out.println(arr[i]);
	
	
	}
	}
	
	@DataProvider
	public String[] getData() {
		String[] abcd = {INDIA,US,UK,ISRAEL};
		return abcd;
	}
	
//	@AfterTest
//	public void print() {
//	if(Res!="") {
//		log.info("INDIAN TRENDS ARE DISPLAYED");
//		log.info("TRENDS IN US:");
//		log.info("TRENDS IN UK:");
//		log.info("TRENDS IN Israel:");
//		
//	}
}
