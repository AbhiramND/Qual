package com.comcast.crm.objectrepository.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
/**
 * @author Raju
 * Contains Login Page elements and Business Library like login()
 */
public class LoginPage extends WebDriverUtility {// Rule-1 create a seprate java class
	// Rule-2 Object Creation

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameEdit;

	@FindBy(name = "user_password")
	private WebElement passwordEdit;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	// Rule-3 Object Initialization
	// Rule-4 Object Utilization
	// Rule-5 Provide Action Or Business method
	/**
	 * login to application based on username,password,driver arguments
	 * @param driver
	 * @param username
	 * @param password
	 */

	public void loginToApp(WebDriver driver, String username, String password) {
		waitForPageToLoad(driver);
		maximize(driver);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
}