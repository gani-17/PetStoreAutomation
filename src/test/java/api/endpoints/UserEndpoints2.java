package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	//method created for getting URL from properties file
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");//load properties file// name of properties file
		return routes;
	}
	
	public static Response CreateUser(User payload) {
		
		String posturl = getURL().getString("posturl");
		
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(posturl);
				
				return res;
		
	}
	
public static Response getUser(String userName) {
	String geturl = getURL().getString("geturl");
		
		Response res = given()
				.pathParam("username", userName)
				.when()
				.get(geturl);
				
				return res;
		
	}

public static Response updateUser(String userName,User payload) {
	String updateurl = getURL().getString("updateurl");
	
	Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
			.when()
			.put(updateurl);
			
			return res;
	
}

public static Response deleteUser(String userName) {
	
	String deleteurl = getURL().getString("deleteurl");
	
	Response res = given()
			.pathParam("username", userName)
			.when()
			.delete(deleteurl);
			
			return res;
	
}

}
