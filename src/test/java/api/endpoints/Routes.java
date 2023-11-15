package api.endpoints;

/*Swagger Petstore

 Base URL: https://petstore.swagger.io/v2
 
 create user(post) https://petstore.swagger.io/v2/user
 get user(get) https://petstore.swagger.io/v2/user/{username}
 update user(put) https://petstore.swagger.io/v2/user/{username}
 delete user(delete) https://petstore.swagger.io/v2/user/{username}

*/
//Routes class contains only URL's

public class Routes {
	
	public static String baseurl = "https://petstore.swagger.io/v2";
	
	//user module
	
	public static String posturl = baseurl + "/user";
	public static String geturl = baseurl + "/user/{username}";
	public static String updateurl = baseurl + "/user/{username}";
	public static String deleteurl = baseurl + "/user/{username}";
	

}
