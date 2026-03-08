package com.pageobjectmanager;

import com.pageobjectmodle.BillingDetails;
import com.pageobjectmodle.CheckOut;
import com.pageobjectmodle.LoginPage;
import com.pageobjectmodle.SearchAndBrowse;
import com.utility.FileReaderManager;

public class PageObjectManager {
	
	private LoginPage loginPage;
	private FileReaderManager fileReaderManager;
	private SearchAndBrowse searchAndBrowse;
	private CheckOut checkOut;
	private BillingDetails billingDetails;
	private static PageObjectManager pageObjectManager;
	
	public LoginPage getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;		
	}
	
	public FileReaderManager getFileReaderManager() {
		if(fileReaderManager == null) {
			fileReaderManager = new FileReaderManager();
		}
		return fileReaderManager;
	}
	
	public SearchAndBrowse getSearchandBrowse() {
		if(searchAndBrowse == null) {
			searchAndBrowse = new SearchAndBrowse();
		}
		return searchAndBrowse;
		
	}
	
	public CheckOut getCheckOut() {
		if(checkOut == null) {
			checkOut = new CheckOut();
		}
		return checkOut;
		
	}
	
	public BillingDetails getBillingDetails() {
		if (billingDetails == null) {
			billingDetails = new BillingDetails();
		}
		return billingDetails;
		
	}
	
	public static PageObjectManager getPageObjectManager() {
		if(pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();
		}
		return pageObjectManager;
	}

}
