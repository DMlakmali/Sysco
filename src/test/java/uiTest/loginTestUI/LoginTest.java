package uiTest.loginTestUI;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import ui.LoginUI.LoginPage;
import base.BaseTest;

public class LoginTest extends BaseTest {

	private LoginPage loginpage;

	@Test
	public void loginTest() {
		loginpage = new LoginPage(driver);
        loginpage.enterEmail("cxweb013@sysco.com");
        loginpage.clickOnNext();
        loginpage.waitUntilLoadingIsCompleted();
        loginpage.enterEmailToProceed("cxweb013@sysco.com");
        loginpage.clickOnNex3();
        loginpage.waitUntilLoginLandingPageIsLoaded();
        loginpage.enterUserName("cxweb013");
        loginpage.clickNext4();
        loginpage.enterPassword("cr7dUfsnpqgHIj");
        loginpage.clickOnSignIn();
        loginpage.clickOnSubmit2();
    }

	@AfterClass
	public void tearDown() {

	}

}
