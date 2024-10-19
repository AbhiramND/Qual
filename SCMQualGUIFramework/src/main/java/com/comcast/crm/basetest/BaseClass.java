package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.genric.webdriverutility.JavaUtility;
import com.comcast.crm.genric.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.homepage.HomePage;
import com.comcast.crm.objectrepository.loginpage.LoginPage;

import comcast.crm.generic.databaseutility.DataBaseUtility;

public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriver driver = null;
	public static WebDriver session_driver = null;

	@BeforeSuite(groups = { "smoke", "regression" })
	public void connectToDb() {
		dbLib.getDbConnection();

		System.out.println("<==connect to DB, Report Config==>");
	}

	@Parameters("Browser")
	@BeforeClass(groups = { "smoke", "regression" })
	public void launchBrowser() throws Throwable {
		System.out.println("Launch The Browser ");
		String browser = fLib.getDataFromPropertiesFile("browser");
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Fire")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void loginToApp() throws Throwable {
		System.out.println("Login to App BM2");
		String url = fLib.getDataFromPropertiesFile("url");
		String username = fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		wlib.get(driver, url);
		lp.loginToApp(driver, username, password);
	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void logoutFromApp() {
		System.out.println("Logout the App ");
		HomePage hp = new HomePage(driver);
		hp.signOut();
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void closeBrowser() {
		System.out.println("Close the Browser ");
		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void closeDbConnection() {
		System.out.println("<==close to DB, Report BackUp==>");
		dbLib.closeDbConnection();

//		report.flush();
	}

}
