package api.loginAPI;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DomainRedirectionRequestDTO {



    private String operationName;
    private Map<String, Object> variables;
    private String query;

    public static DomainRedirectionRequestDTO domainRedirectionRequestDTO(Map<String, Object> variables) {
        return DomainRedirectionRequestDTO.builder()
                .operationName("GetFeDomainRedirectionUrl")
                .variables(variables)
                .query(
                        "query GetFeDomainRedirectionUrl($email: String!, $currentDomain: String!) {\n" +
                                "  getFeDomainRedirectionUrl(email: $email, currentDomain: $currentDomain) {\n" +
                                "    redirectTo\n" +
                                "  }\n" +
                                "}"
                )
                .build();
    }
	
}
