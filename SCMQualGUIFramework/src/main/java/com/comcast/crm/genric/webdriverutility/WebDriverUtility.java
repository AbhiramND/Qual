package com.comcast.crm.genric.webdriverutility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriverWait explicitwait = null;
	WebDriver driver = null;

	public ChromeOptions notificationAlert() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disabled -notifications");
		return ops;
	}

	public String getScreenShot(WebDriver driver, String screenShotName) throws Throwable {
		JavaUtility jlib = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName + "+" + jlib.date() + ".png");
		String path = ts.getScreenshotAs(OutputType.BASE64);
			FileHandler.copy(src, dst);
		
		return path;
	}

	public void scrollIntoViewExecuteScript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void get(WebDriver driver, String url) {
		driver.get(url);
	}

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void findElementXpath(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath));
	}

	public void findElementId(WebDriver driver, String id) {
		driver.findElement(By.id(id));
	}

	public void findElementName(WebDriver driver, String name) {
		driver.findElement(By.name(name));
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementContains(WebDriver driver, WebElement element, String title) {
		explicitwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		explicitwait.until(ExpectedConditions.titleContains(title));
	}

	public void waitForElementVisbility(WebDriver driver, WebElement element) {
		explicitwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		explicitwait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementInvisbility(WebDriver driver, WebElement element) {
		explicitwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		explicitwait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void fluentWaitElementVisibility(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver);
		fluentwait.pollingEvery(Duration.ofSeconds(1));
		fluentwait.until(ExpectedConditions.visibilityOf(element));
	}

	public void fluentWait(WebDriver driver) {

	}

	// switching window related methods
	public void switchToTabURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialURL)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}

	}

	// frame related methods
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToParentframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// alert pop up related methods

	public void switchToAlerAcceptt(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlerDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		;
	}

	// DropDown Related methods
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void deselectAll(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}

	// mouse hover related methods
	public void mouseMoveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement src, WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}

	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	public void click(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

}
