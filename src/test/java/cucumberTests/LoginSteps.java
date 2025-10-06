package cucumberTests;

import LoginUI.LoginPage;
import base.BaseTest;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseTest {

	private LoginPage loginpage;

	public LoginSteps() {
		setUp();
	}

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		loginpage = new LoginPage(driver);

	}

	@When("user enters valid {string}")
	public void user_enters_valid(String email) {
		loginpage.enterEmail(email);
	}

	@When("user clicks on next button")
	public void user_clicks_on_next_button() {
		loginpage.clickOnNext();
		loginpage.waitUntilLoadingIsCompleted();
	}

	@When("user enters valid {string} again")
	public void user_enters_valid_again(String email) {
		loginpage.enterEmailToProceed(email);
	}
	
	@Given("user clicks on next button again")
	public void user_clicks_on_next_button_again() {
	    loginpage.clickOnNex3();
	    loginpage.waitUntilLoginLandingPageIsLoaded();
	}
	
	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    loginpage.enterUserName(username);
	}
	
	@When("user clicks on next button to proceed")
	public void user_clicks_on_next_button_to_proceed() {
		loginpage.clickNext4();
	}

	@When("user enters password  {string}")
	public void user_enters_password(String password) {
		loginpage.enterPassword(password);
	    
	}

	@When("clicks the login button")
	public void clicks_the_login_button() {
		loginpage.clickOnSignIn();
	}
	
	@When("user clicks on submit button to stay signed in")
	public void user_clicks_on_submit_button_to_stay_signed_in() {
	   loginpage.clickOnSubmit2();
	}

	@Then("user should be navigated to the home page")
	public void user_should_be_navigated_to_the_home_page() {

	}

}






