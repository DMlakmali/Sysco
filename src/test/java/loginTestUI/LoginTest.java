package loginTestUI;

import org.testng.annotations.Test;

import LoginUI.LoginPage;
import base.BaseTest;

public class LoginTest extends BaseTest {

	private LoginPage loginpage;

	@Test
	public void loginTest() {
		loginpage = new LoginPage(driver);
		loginpage.enterUserName("cxweb013@sysco.com");

	}

}
