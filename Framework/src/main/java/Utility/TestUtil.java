package Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtil {
	
	public static String getresponseasstring(Response response)
	{
		String res = response.getBody().asString();
		return res;
	}

	public static JsonPath jsonparser(String response)
	{
	   JsonPath jsonresp=new JsonPath(response);
		
		return jsonresp;
		
	}
	
	public static int getstatuscode(Response response)
	{
	   int Status=response.getStatusCode();
	   return Status;
	}
	
	public static String getstatusmessage(Response response)
	{
	   String message=response.getStatusLine();
	   return message;
	}
}
