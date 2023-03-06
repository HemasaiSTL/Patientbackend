package com.stlh.paitentbackend;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaitentBackendApplicationTests {
	
	@Test
	@Order(1)
	public void testSignup() {
		String jsonbody="{\"firstname\":\"Sample\",\"lastname\":\"test\",\"gender\":\"Female\",\"email\":\"sample@gmail.com\",\"age\":\"22\",\"password\":\"sample123\",\"phnnumber\":\"1234567890\"}";
		String res=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonbody)
				.when()
				.post("http://localhost:5052/api/patients/add")
				.then()
				.assertThat().statusCode(201)
				.extract().response().asString();
	}
	
	@Test
	@Order(2)
	public void testLogin() {
		String jsonbody= "{\"email\" : \"sample@gmail.com\",\"password\" : \"sample123\"}";
		String token=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonbody)
				.when()
				.post("http://localhost:5052/api/patients/authenticate")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}
	
	
	@Test
	@Order(3)
	public void testgetpatient() {
		String jsonbody= "{\"email\" : \"sample@gmail.com\",\"password\" : \"sample123\"}";
		String token=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonbody)
				.when()
				.post("http://localhost:5052/api/patients/authenticate")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
		
		String result=given()
				.header("Authorization","Bearer "+token).contentType(ContentType.JSON).accept(ContentType.JSON)
				.when()
				.get("http://localhost:5052/api/patients/get/sample@gmail.com")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}
	
	@Test
	@Order(4)
	public void testdeletepatient() {
		String jsonbody= "{\"email\" : \"sample@gmail.com\",\"password\" : \"sample123\"}";
		String token=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonbody)
				.when()
				.post("http://localhost:5052/api/patients/authenticate")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
		
		String result=given()
				.header("Authorization","Bearer "+token).contentType(ContentType.JSON).accept(ContentType.JSON)
				.when()
				.delete("http://localhost:5052/api/patients/delete/sample@gmail.com")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}
}
