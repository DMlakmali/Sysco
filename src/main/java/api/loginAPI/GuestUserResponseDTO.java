package loginAPI;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestUserResponseDTO {
    private Data data;

    @Getter
    @Setter
    public static class Data {
        private GetGuestAccount getGuestAccount;
    }

    @Getter
    @Setter
    public static class GetGuestAccount {
        private String sellerId;
        private String siteId;
        private String sellerAccountId;
        private String shopAccountId;
        private String hash;
    }
}
