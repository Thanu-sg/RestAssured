package test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class post1 {
	
Properties	prop = new Properties();

public static org.apache.logging.log4j.Logger log1;
String ConsumerKey= null;
String ConsumerSecretKey=null;
String AccessToken=null;
String AccessTokenSecret=null;
String id="846529860352774144";
@BeforeSuite
public void Bsuite() throws FileNotFoundException, IOException{
  String log4jConfigFile = ("C:\\Users\\intern 17\\eclipse-workspace\\RestAutomation\\src\\main\\java\\Resource\\log4j2.xml");
//   String log4jConfigFile = ("/Users/abdulazeem/Desktop/Qualitest/QTRecognition/src/main/java/resources/log4j2.xml");
  ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
  Configurator.initialize(null, source);
  log1 = LogManager.getLogger(post1.class.getName());  
}
  
	
	@Test
	public void PostAPI() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\intern 17\\eclipse-workspace\\RestAutomation\\src\\main\\java\\Resource\\data.properties");
		prop.load(fis);
		
		RestAssured.baseURI= "https://api.twitter.com/1.1/statuses/";
		Response res = given().auth().oauth(prop.getProperty("CONSUMERKEY"), prop.getProperty("CONSUMERSECRET") , prop.getProperty("ACCESSTOKEN") , prop.getProperty("TOKENSECRET")).
				queryParam("status","I am learning API testing using RestAssured123512  #Qualitest").
				when().post("/update.json").then().extract().response();
		
		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String id = js.get("id").toString();
		log1.info(id);
        System.out.println(id);
		String text = js.get("text").toString();
		System.out.println(text);
		log1.info(text);
	}
}

