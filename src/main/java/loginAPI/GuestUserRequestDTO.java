package loginAPI;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class GuestUserRequestDTO {



    private String operationName;
    private Map<String, Object> variables;
    private String query;

    public static GuestUserRequestDTO guestUserRequestDTO(Map<String, Object> variables) {
        return GuestUserRequestDTO.builder()
                .operationName("GetGuestAccount")
                .variables(variables)
                .query(
                        "query GetGuestAccount($locationCode: String!, $country: String!) {\n" +
                                "  getGuestAccount(locationCode: $locationCode, country: $country) {\n" +
                                "    sellerId\n" +
                                "    siteId\n" +
                                "    sellerAccountId\n" +
                                "    shopAccountId\n" +
                                "    hash\n" +
                                "  }\n" +
                                "}\n"
                )
                .build();
    }
	
}
