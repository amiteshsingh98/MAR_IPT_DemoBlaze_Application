package com.pageobjectmodle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceElements.CheckOutInterfaceElement;

public class CheckOut extends Base_Class implements CheckOutInterfaceElement {
	
	@FindBy(id = cart_id)
	private WebElement cart;
	@FindBy(xpath = placeorder_xpath)
	private WebElement placeorder;
	
	public CheckOut() {
		PageFactory.initElements(driver, this);
	}
	
	public void productCheckOut() {
		clickOnElement(cart);
		takeScreenShots();
		clickOnElement(placeorder);

	}

}
