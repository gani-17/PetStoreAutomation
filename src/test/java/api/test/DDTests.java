package api.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	
	public void testpostuser(String UserID, String Username, String FirstName, String LastName, String Email, String Password, String Phone){
		{
			
			User userpayload = new User();
			
			userpayload.setId(Integer.parseInt(UserID));
			userpayload.setUsername(Username);
			userpayload.setFirstName(FirstName);
			userpayload.setLastName(LastName);
			userpayload.setEmail(Email);
			userpayload.setPassword(Password);
			userpayload.setPhone(Phone);
			Response res = UserEndpoints.CreateUser(userpayload);
			
			Assert.assertEquals(res.getStatusCode(), 200);
		}
		
		}
		
	
			
			
	
		@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
		
		public void testdeleteuser( String Username){
			{
				
				
				Response res = UserEndpoints.deleteUser(Username);
				
				Assert.assertEquals(res.getStatusCode(), 200);;
				
				
		}
			
		
		
	}
		
		
 
		
		
		
		
	
	

}
