package supplychainmanagement.qual.objectrepository.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Raju
 * Contains Login Page elements and Business Library like login()
 */
public class LoginPage  {

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	
}