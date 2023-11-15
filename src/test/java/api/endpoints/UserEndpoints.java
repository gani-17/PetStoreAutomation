package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response CreateUser(User payload) {
		
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.posturl);
				
				return res;
		
	}
	
public static Response getUser(String userName) {
		
		Response res = given()
				.pathParam("username", userName)
				.when()
				.get(Routes.geturl);
				
				return res;
		
	}

public static Response updateUser(String userName,User payload) {
	
	Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
			.when()
			.put(Routes.updateurl);
			
			return res;
	
}

public static Response deleteUser(String userName) {
	
	Response res = given()
			.pathParam("username", userName)
			.when()
			.delete(Routes.deleteurl);
			
			return res;
	
}

}
