package com.pageobjectmodle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceElements.SearchAndBrowseInterfaceElements;

public class SearchAndBrowse extends Base_Class implements SearchAndBrowseInterfaceElements {
	
	@FindBy(linkText = laptop_linktext)
	private WebElement laptopsection;
	@FindBy(xpath = selectlaptop_xpath)
	private WebElement selectsonyvaioi5;
	@FindBy(css = addtocart_css)
	private WebElement addtocart;
	
	public SearchAndBrowse() {
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart() {
		clickOnElement(laptopsection);
		clickOnElement(selectsonyvaioi5);
		explicitWait(addtocart, 5, "element visible");
		clickOnElement(addtocart);
		explicitWait(addtocart, 5, "Check Alert");
		System.out.println("\nGet Alert Text: ");
		simpleDismissAlert("accept");

	}
	

}
