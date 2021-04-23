
//teste commit
package workingWithSelenium.services;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Scanner;

import org.hamcrest.Matchers;

public class FruitShopCustomer {

	Scanner read = new Scanner(System.in);
	private static String base_url = "https://api.predic8.de:443/shop/customers/";
	private int id;

	public int setId(int userId) {
		System.out.print("Informe o ID: ");
		return userId = read.nextInt();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void postCustomerValidationBodyTest() {
		System.out.println("\n## Criando cliente ##\n");

		JSONObject requestParams = new JSONObject();
		String dadoUsername;
		String dadoLastname;

		System.out.print("firstname: ");
		requestParams.put("firstname", dadoUsername = read.next());
		System.out.print("lastname: ");
		requestParams.put("lastname", dadoLastname = read.next());

		Response response = given().body(requestParams.toJSONString()).contentType(ContentType.JSON).when().post(base_url)
				.then().statusCode(201).body("firstname", Matchers.equalTo(dadoUsername))
				.body("lastname", Matchers.equalTo(dadoLastname)).extract().response();

		String customerUrl = response.path("customer_url");
		String userId = customerUrl.replaceAll("(?:[^\\d]+)", "");
		System.out.println("\nURL do novo cliente: " + customerUrl);
		System.out.println("ID do novo cliente: " + userId);
	}

	@Test
	public void getCustomerById() {
		System.out.println("\n## Listando cliente pelo ID ##\n");

		int userId = setId(this.id);

		Response response = given().when().get(base_url + userId).then().assertThat().statusCode(200).extract().response();

		String firstName = response.path("firstname");
		String lastName = response.path("lastname");

		System.out.println("\nNome: " + firstName);
		System.out.println("Sobrenome: " + lastName);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void putCustomerTestById() {
		System.out.println("\n## Alterando dados cliente ##\n");
		int userId = setId(this.id);
		
		Response responseGet = given().when().get(base_url + userId).then().assertThat().statusCode(200).extract().response();
		
		System.out.print("\nDados atuais do cliente");
		String firstName = responseGet.path("firstname");
		String lastName = responseGet.path("lastname");

		System.out.println("\nfirstname: " + firstName);
		System.out.println("lastname: " + lastName);
		
		JSONObject requestParams = new JSONObject();

		String dadoUsername;
		String dadoLastname;

		System.out.print("\nAlterar o campo firstname: ");
		requestParams.put("firstname", dadoUsername = read.next());
		System.out.print("Alterar o campo lastname: ");
		requestParams.put("lastname", dadoLastname = read.next());

		given().body(requestParams.toJSONString()).contentType(ContentType.JSON).when()
				.put(base_url + userId).then().statusCode(200).body("firstname", Matchers.equalTo(dadoUsername))
				.body("lastname", Matchers.equalTo(dadoLastname));

		System.out.println("\nCliente atualizado com sucesso");

	}

	@Test
	public void deleteCustomerTestById() {
		System.out.println("\n## Deletando cliente pelo ID ##\n");

		int userId = setId(this.id);

		Response responseGet = given().when().get(base_url + userId).then().assertThat().statusCode(200).extract()
				.response();

		String firstName = responseGet.path("firstname");
		String lastName = responseGet.path("lastname");
		String fullName = firstName + " " + lastName;

		System.out.println("\nCliente [" + fullName + "] deletado com sucesso");

	}

}