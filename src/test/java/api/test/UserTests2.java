package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User userpayload;
	public Logger logger;
	
	@BeforeClass
	
	public void setupData() {
		
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	
	public void testpostuser() {
		
		logger.info("******user is created*******");
		Response res = UserEndpoints2.CreateUser(userpayload);
		
		res.then().log().all();
		
	}
	
@Test(priority=2)
	
	public void testgetuser() {
		Response res = UserEndpoints2.getUser(this.userpayload.getUsername());
		
		res.then().log().all();
		
	}
@Test(priority=3)

public void testupdateuser() {
	
	//update data with payload
	
	userpayload.setUsername(faker.name().username());
	userpayload.setFirstName(faker.name().firstName());
	userpayload.setLastName(faker.name().lastName());
	
	
	Response res = UserEndpoints2.updateUser(this.userpayload.getUsername(), userpayload);
	
	res.then().log().all();
	
}

@Test(priority=4)

public void testdeleteuser() {
	Response res = UserEndpoints2.getUser(this.userpayload.getUsername());
	
	res.then().log().all();
	
}


}
