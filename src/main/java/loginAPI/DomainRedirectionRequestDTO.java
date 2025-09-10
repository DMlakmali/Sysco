package loginAPI;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DomainRedirectionRequestDTO {

    
		
	   String query =
	        "query GetFeDomainRedirectionUrl($email: String!, $currentDomain: String!) { " +
	        "  getFeDomainRedirectionUrl(email: $email, currentDomain: $currentDomain) { " +
	        "    redirectTo " +
	        "  } " +
	        "}";

	    Map<String, Object> variables;
	
}
