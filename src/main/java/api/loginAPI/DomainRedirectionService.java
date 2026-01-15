package api.loginAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class DomainRedirectionService {

    private ObjectMapper objectMapper = new ObjectMapper();
    DomainRedirectionResponseDTO domainredirectionResponseDTO = new DomainRedirectionResponseDTO();

    public DomainRedirectionResponseDTO domainReDirection(String email, String currentDomain)  {

        try {

            RestAssured.baseURI = "https://gateway-api.qa.cx-shop-nonprod.sysco-go.com/graphql";

            Map<String, Object> variables = new HashMap<>();
            variables.put("email", email);
            variables.put("currentDomain", currentDomain);

            DomainRedirectionRequestDTO payload =
                    DomainRedirectionRequestDTO.domainRedirectionRequestDTO(variables);

            Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).when().post();


            domainredirectionResponseDTO = objectMapper.readValue(response.asString(),
                    DomainRedirectionResponseDTO.class);


        }catch(Exception e){
           e.printStackTrace();
        }

        return domainredirectionResponseDTO;
    }

}
