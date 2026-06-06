package loginAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class GuestUserService {

    private static final Logger logger = LoggerFactory.getLogger(GuestUserService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    GuestUserResponseDTO GuestUserResponseDTO = new GuestUserResponseDTO();

    public GuestUserResponseDTO GuestUser(String locationCode, String country) {

        try {

            RestAssured.baseURI = "https://gateway-api.shop.sysco.com/graphql";
            
            // Disable SSL certificate verification (use with caution - only for testing)
            RestAssured.useRelaxedHTTPSValidation();

            Map<String, Object> variables = new HashMap<>();
            variables.put("locationCode", locationCode);
            variables.put("country", country);

            GuestUserRequestDTO payload =
                    GuestUserRequestDTO.guestUserRequestDTO(variables);

            Response response = RestAssured.given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJ2aWQiOiJudWxsIiwiYXVkIjoiY3hzLXNob3AiLCJyb2xlIjoiR1VFU1QiLCJpc3MiOiJzeXNjbyIsImNsaWVudF9jb29raWVfbmFtZSI6Ik1TU19TVEFURUZVTCIsInNob3BfdXNlcl90eXBlIjoiZ3Vlc3QiLCJleHAiOjE3ODA4OTMyNTQsImlhdCI6MTc4MDI4ODQ1NCwiZGVmYXVsdF9jb3VudHJ5IjoiVVMifQ.W6sYTs3vCWUf7p78xFyrqf-042sdYAT5DXyvD1uMRYqJtRPuW4RzQqL_xwTWUniruZd4PMRufuOcTEWqVQ8NMPlCkVhx1j4ARuQV1yc8RZXQqA84ogrS8QlFfFyeKh6q7WfyNAA7tfD7zoNBA_XthKqvHEQfDfV22IEXjvTgB9Ik8JuSmYIgu-f1mWfnDxPLwlfNZnhwvG5MxeTXQWEalRIjPdzPfK6D_WM9-vccMatRBylWY9Ou7XU-isXoGmILMfT1djma03VGDpmgjZo95vV9Q5C6fQGBSnv2lMd6Kuw1x9fwbtPi8e5Fal8ftzdHFCdvQ6IzpeQkYRVkLH_QnQ")
                    .when()
                    .post();

            // Log response status and body for debugging
            logger.info("Response Status Code: " + response.getStatusCode());
            String responseBody = response.asString();
            logger.info("Response Body: " + responseBody);
            System.out.println(responseBody);

            // Check if response is successful
            if (response.getStatusCode() != 200) {
                logger.error("API call failed with status code: " + response.getStatusCode());
                logger.error("Response: " + responseBody);
                return GuestUserResponseDTO;
            }

            // Check if response is JSON (not HTML error page)
            if (responseBody == null || responseBody.trim().isEmpty()) {
                logger.error("Response body is empty");
                return GuestUserResponseDTO;
            }

            if (responseBody.trim().startsWith("<")) {
                logger.error("Response is HTML, not JSON. API may have returned an error page");
                logger.error("HTML Response: " + responseBody);
                return GuestUserResponseDTO;
            }

            // Parse JSON response
            GuestUserResponseDTO = objectMapper.readValue(responseBody,
                    GuestUserResponseDTO.class);
            logger.info("Successfully parsed GuestUserResponseDTO");

        } catch (Exception e) {
            logger.error("Error occurred while fetching Guest User account info", e);
            e.printStackTrace();
        }

        return GuestUserResponseDTO;
    }

}
