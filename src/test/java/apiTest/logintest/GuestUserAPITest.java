package logintest;

import loginAPI.GuestUserService;
import loginAPI.GuestUserResponseDTO;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GuestUserAPITest {

    GuestUserService guestUserService = new GuestUserService();

	@Test
	public void verifyThatGetGuestAccountFetchesAccountInfo(){

        try {
            GuestUserResponseDTO response = guestUserService.GuestUser("02108", "US");
            
            // Add null checks to prevent NullPointerException
            Assert.assertNotNull(response, "Response should not be null");
            Assert.assertNotNull(response.getData(), "Response data should not be null");
            Assert.assertNotNull(response.getData().getGetGuestAccount(), "GetGuestAccount should not be null");
            
            String shopAccountId = response.getData().getGetGuestAccount().getShopAccountId();
            System.out.println("Shop Account ID: " + shopAccountId);
            Assert.assertNotNull(shopAccountId, "Shop Account ID should not be null");
            
        } catch (Exception e) {
            System.err.println("Test failed with exception: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }

	}

}
