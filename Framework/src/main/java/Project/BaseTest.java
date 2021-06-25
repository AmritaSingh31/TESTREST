package Project;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.PayLoadconvertor;
import Utility.URL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	static Response response;
	
	@Test
	public static String Login() throws IOException
	{
		//what is my first step//URL//body
		String endpointurl = URL.getEndpoint("/user/login");
		String loginpayload=PayLoadconvertor.generatepayloadString("Login.json");
		response = RestCalls.postRequest(endpointurl, loginpayload);
		System.out.println("Response " + response);
		//this is to fetch the response body
		String res=response.getBody().asString();
		System.out.println("Resp " + res); 
		//convert to jason path
		JsonPath jsonresp= new JsonPath(res);
		String accesstoken=jsonresp.getString("accessToken");
		System.out.println("Correct Token " + accesstoken);
		return accesstoken;
	
	}
}
