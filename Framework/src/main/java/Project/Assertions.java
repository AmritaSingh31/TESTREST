package Project;

import org.testng.Assert;

import Utility.TestUtil;
import io.restassured.response.Response;

public class Assertions {
	
	public static void verifystatuscode(Response response,int status)
	
	{
		Assert.assertEquals(TestUtil.getstatuscode(response), status);
	}


}
