package ui.LoginUI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver webdriver) {
		super(webdriver);

	}

	private String inputEmail = "//input[@data-id=\"txt_login_email\"]";
	private String btnNext = "//button[@data-id='btn_next']";
	private String inputUserName = "//input[@id='userInput']";
	private String inputPassword = "//input[@id='password']";
	private String btnNext2 = "//button[@id=\"userStoreFormSubmit\"]";
	private String btnSignIn = "//button[@id=\"signIn\"]";
	private String inputEmail2 = "//input[@type=\"email\"]";
	private String btnNext3 = "//input[@type=\"submit\"]";
	private String btnNext4 = "//div[@id=\"nextBtnField\"]";
	private String btnSubmit2 = "//input[@type='submit']";

	public void enterEmail(String email) {
		sendKeys(inputEmail, email);
	}

	public void clickOnNext() {
		click(btnNext);
	}

	public void enterUserName(String username) {
		sendKeys(inputUserName, username);
	}

	public void enterPassword(String password) {
		sendKeys(inputPassword, password);

	}

	public void clickOnNext2() {
		click(btnNext2);
	}

	public void clickOnSignIn() {
		click(btnSignIn);
	}

	public void enterEmailToProceed(String email) {
		sendKeys(inputEmail2, email);

	}

	public void clickOnNex3() {
		click(btnNext3);
	}

	public void clickNext4() {
		click(btnNext4);
	}

	public void waitUntilLoginLandingPageIsLoaded() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'login-body')]")));
	}

	public void clickOnSubmit2() {
		click(btnSubmit2);
	}

}
