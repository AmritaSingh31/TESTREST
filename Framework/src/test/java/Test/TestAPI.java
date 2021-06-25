package Test;

import Project.Assertions;
import Project.BaseTest;
import Project.RestCalls;
import Utility.TestUtil;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAPI {
	public String accesstoken;
	public String id;
	Response response;
	@BeforeTest
	public void setup() throws IOException
	{
		accesstoken=BaseTest.Login();
		System.out.println(accesstoken);
	}

	@Test(priority=0)
	public void getallusers()
	{
		String endpointurl=URL.getEndpoint("/user");
		response = RestCalls.getRequestwithheader(endpointurl, accesstoken);
		String res=TestUtil.getresponseasstring(response);
		JsonPath jsonresp=TestUtil.jsonparser(res);
		
		id = jsonresp.getString("users[2]._id");
		System.out.print(id);
		Assertions.verifystatuscode(response, 200);
	}
	
	@Test(priority=1)
	public void deleteuser()
	{
		String formendpointurl=URL.getEndpoint("/user/" + id);
		response = RestCalls.deleteRequestwithheader(formendpointurl , accesstoken);
		String res=TestUtil.getresponseasstring(response);
		JsonPath jsonresp=TestUtil.jsonparser(res);
		
		//id = jsonresp.getString("users[2]._id");
		System.out.print("User Deleted");
		Assertions.verifystatuscode(response, 200);
	}
	
}
