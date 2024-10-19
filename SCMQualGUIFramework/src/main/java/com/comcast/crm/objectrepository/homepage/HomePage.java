package com.comcast.crm.objectrepository.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(xpath = "//a[@href='index.php?module=Assets&action=index']")
	private WebElement assetsLink;

	@FindBy(xpath = "//a[@name='Purchase Order']")
	private WebElement purchaseOrderLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(xpath = "//a[@name='Sales Order']")
	private WebElement salesOrderLink;

	@FindBy(xpath = "//a[@href='index.php?module=PriceBooks&action=index']")
	private WebElement priceBooksLink;

	@FindBy(name = "Invoice")
	private WebElement invoiceLink;

	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunitiesLink;

	@FindBy(linkText = "Products")
	private WebElement productLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	// object initialization
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPriceBooksLink() {
		return priceBooksLink;
	}

	public WebElement getAssetsLink() {
		return assetsLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	WebDriver driver;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void navigateToCampaingn() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignsLink.click();
	}

	@FindBy(linkText = "Vendors")
	private WebElement venderLink;

	public WebElement getVenderLink() {
		return venderLink;
	}

	public void navigateToVender() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		venderLink.click();
	}

	public void signOut() {
		adminImg.click();
		signOutLink.click();
	}

}
