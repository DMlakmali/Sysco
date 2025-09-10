package logintest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import loginAPI.DomainRedirectionRequestDTO;

public class DomainRedirectionAPITest {

	@Test
	public void domainredirectiontest() {

		RestAssured.baseURI = "https://gateway-api.shop.sysco.com/graphql";

		Map<String, Object> variables = new HashMap<>();
		variables.put("email", "cxweb013@sysco.com");
		variables.put("currentDomain", ".com");

		Map<String, Object> payload = new HashMap<>();
		payload.put("operationName", "GetFeDomainRedirectionUrl");
		payload.put("variables", variables);
		payload.put("query",
				"query GetFeDomainRedirectionUrl($email: String!, $currentDomain: String!) {\n"
						+ "  getFeDomainRedirectionUrl(email: $email, currentDomain: $currentDomain) {\n"
						+ "    redirectTo\n" + "  }\n" + "}");

		ValidatableResponse response = RestAssured.given().contentType(ContentType.JSON).body(payload).when().post()
				.then().assertThat().statusCode(200);
	}

}
