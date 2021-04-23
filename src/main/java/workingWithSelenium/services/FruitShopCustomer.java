
package workingWithSelenium.services;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Scanner;

import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.containsString;

public class FruitShopCustomer {
	
	private static String base_url = "https://api.predic8.de:443/shop/customers/";

	@Test
	public void getResponseStatus() {
		given().when().get(base_url).then().assertThat().statusCode(200);
		System.out.println(given().when().get(base_url).then().assertThat().statusCode(200).extract().path("id"));
	}
	
	//Get/{id}
	@Test
	public void getCustomerById() {
		Response response = given().when().get(base_url + 350).then()
		.assertThat().statusCode(200)
		.extract().response();
		
		String firstName = response.path("firstname");
		String lastName = response.path("lastname");
		
		System.out.println("Nome: " + firstName);
		System.out.println("Sobrenome: " + lastName);
		
	}

	@SuppressWarnings({ "unchecked" })
	@Test
	public void postCustomerTest() {
		JSONObject requestParams = new JSONObject();
		String dadoUsername = "Thomas";
		String dadoLastname = "Debruços";
		requestParams.put("firstname", dadoUsername);
		requestParams.put("lastname", dadoLastname);
		System.out.println(requestParams.toJSONString());
		System.out.println(base_url);
		given().body(requestParams.toJSONString()).contentType(ContentType.JSON).when().post(base_url).then()
				.statusCode(201).body("firstname", Matchers.equalTo(dadoUsername))
				.body("lastname", Matchers.equalTo(dadoLastname));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void postCustomerValidationBodyTest() {
		JSONObject requestParams = new JSONObject();
		String dadoUsername = "Thomas";
		String dadoLastname = "Debruços";
		
		requestParams.put("firstname", dadoUsername);
		requestParams.put("lastname", dadoLastname);
		
		Response response = given()
				.body(requestParams.toJSONString())
				.contentType(ContentType.JSON).when().post(base_url).then().statusCode(201)
				.body("firstname", Matchers.equalTo(dadoUsername))
				.body("lastname", Matchers.equalTo(dadoLastname)).extract().response();
		
		String customerUrl = response.path("customer_url");
		String userId = customerUrl.replaceAll("(?:[^\\d]+)", "");
		System.out.println("URL do novo cliente: " + customerUrl);
		System.out.println("ID do novo cliente: " + userId);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void putCustomerTest() {
		JSONObject requestParams = new JSONObject();
		String dadoUsername = "Adilson-PUT";
		String dadoLastname = "Ferreira-PUT";
		requestParams.put("firstname", dadoUsername);
		requestParams.put("lastname", dadoLastname);

		given().body(requestParams.toJSONString()).contentType(ContentType.JSON)
		.when().put(base_url + "602").then()
		.statusCode(200).body(containsString(dadoUsername)).log();
	}

	@Test
	public void deleteCustomerTest() {
		when().delete(base_url + "602").then().statusCode(204).log();
	}
}
//Vou tentar deixar o ID dinâmico e guardar ele numa variável
//Task -> Criar dois testes para cada verbo do RestAssred (sempre em customers) 
//No mínimo são 8
