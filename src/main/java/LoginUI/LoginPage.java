package LoginUI;

import org.openqa.selenium.WebDriver;

import base.PageBase;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver webdriver) {
		super(webdriver);

	}

	private String inputUserName = "//input[@data-id=\"txt_login_email\"]";

	public void enterUserName(String userName) {
		sendKeys(inputUserName,userName);
	}

}
