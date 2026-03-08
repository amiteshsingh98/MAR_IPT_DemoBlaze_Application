package com.pageobjectmodle;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceElements.BillingDetailsInterfaceElement;
import com.pageobjectmanager.PageObjectManager;

public class BillingDetails extends Base_Class implements BillingDetailsInterfaceElement {
	
	//Billing Details and purchase
	@FindBy(id = name_id)
	private WebElement name;
	@FindBy(xpath = country_xpath)
	private WebElement country;
	@FindBy(css = city_css)
	private WebElement city;
	@FindBy(id = creditcard_id )
	private WebElement creditcard;
	@FindBy(id = month_id )
	private WebElement month;
	@FindBy(id = year_id )
	private WebElement year;
	@FindBy(xpath = purchase_xpath)
	private WebElement purchase;
	@FindBy(xpath = getpurchasedetails_xpath)
	private WebElement getpurchasedetails;
	@FindBy(xpath = purchasecompleted_xpath)
	private WebElement purchasecompleted;
	@FindBy(linkText = logout_linkText)
	private WebElement logout;
		
	public BillingDetails() {
		PageFactory.initElements(driver, this);
	}
	
	public void purchaseCartOrders() throws IOException, InterruptedException {
		explicitWait(name, 5, "element visible");
		passInput(name, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("name"));
		passInput(country, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("country"));
		passInput(city, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("city"));
		passInput(creditcard, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("creditcard"));
		passInput(month, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("month"));
		passInput(year, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("year"));
		clickOnElement(purchase);
		System.out.println("\nPurchaseDetails: ");
		getText(getpurchasedetails);
		takeScreenShots();
		//explicitWait(purchasecompleted, 5, "clickable");
		//explicitWait(purchasecompleted, 5, "element visible");
		Thread.sleep(1000);
		clickOnElement(purchasecompleted);
		explicitWait(logout, 5, "element visible");
		clickOnElement(logout);
	}

}
