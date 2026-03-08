package com.runner;

import java.io.IOException;

import org.openqa.selenium.By;
import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class Test_Class extends Base_Class {
	
	public static void main (String[] args) throws IOException, InterruptedException {
		
		launchBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("browser"));
		launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("url"));
		PageObjectManager.getPageObjectManager().getLoginPage().validLogin();		
		PageObjectManager.getPageObjectManager().getSearchandBrowse().addProductToCart();
		PageObjectManager.getPageObjectManager().getCheckOut().productCheckOut();
		PageObjectManager.getPageObjectManager().getBillingDetails().purchaseCartOrders();
	}

}
