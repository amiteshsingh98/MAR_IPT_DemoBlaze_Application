package com.pageobjectmodle;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceElements.LoginInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class LoginPage extends Base_Class implements LoginInterfaceElements {
	@FindBy(xpath = Login_xpath)
	private WebElement login;
	@FindBy(id = user_id)
	private WebElement username;
	@FindBy(css = password_css)
	private WebElement password;
	@FindBy(xpath = signin_xpath)
	private WebElement signin; 
	@FindBy(id=title_id)
	private WebElement title;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validLogin() throws IOException {
		clickOnElement(login);
		explicitWait(username, 5, "element visible");
		passInput(username, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("username"));
		passInput(password, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("password"));
		clickOnElement(signin);
		explicitWait(title, 5, "element visible");
        System.out.println("Get Logged in USER: ");
        getText(title);
        takeScreenShots();
	}
}
