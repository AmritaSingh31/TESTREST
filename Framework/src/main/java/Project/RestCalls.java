package Project;

import static io.restassured.RestAssured.given;
import org.jsoup.Connection.Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCalls {

	public static Response getRequest(String URI)
	{
	   RequestSpecification requestspecification = RestAssured.given();
	   requestspecification.contentType(ContentType.JSON);
	   Response response = requestspecification.get(URI);
	   return response;
	}
	
	
	public static Response getRequestwithheader(String URI,String accesstoken)
	{
	   RequestSpecification requestspecification = RestAssured.given();
	   requestspecification.contentType(ContentType.JSON);
	   requestspecification.header("Authorization","bearer " + accesstoken);
	   Response response = requestspecification.get(URI);
	   return response;
	}
	
	public static Response postRequest(String URI,String strjson)
	{
	   RequestSpecification requestspecification = RestAssured.given().body(strjson);
	   requestspecification.contentType(ContentType.JSON);
	   Response response = requestspecification.post(URI);
	   return response;
	}
	
	public static Response putRequest(String URI,String strjson)
	{
	   RequestSpecification requestspecification = RestAssured.given().body(strjson);
	   requestspecification.contentType(ContentType.JSON);
	   Response response = requestspecification.put(URI);
	   return response;
	}
	
	public static Response deleteRequest(String URI,String strjson)
	{
	   RequestSpecification requestspecification = RestAssured.given().body(strjson);
	   requestspecification.contentType(ContentType.JSON);
	   Response response = requestspecification.delete(URI);
	   return response;
	}
	
	public static Response deleteRequestwithheader(String URI,String accesstoken)
	{
	   RequestSpecification requestspecification = RestAssured.given();
	   requestspecification.contentType(ContentType.JSON);
	   requestspecification.header("Authorization","bearer " + accesstoken).log().all();
	   Response response = requestspecification.delete(URI);
	   return response;
	}
}
