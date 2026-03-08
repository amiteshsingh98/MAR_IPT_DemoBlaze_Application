package com.interfaceElements;

public interface BillingDetailsInterfaceElement {
	
	//Billing Deatils
	String name_id = "name";
	String country_xpath ="//input[@id='country']";
	String city_css = "input#city";
	String creditcard_id = "card";
	String month_id = "month";
	String year_id = "year";
	String purchase_xpath = "//button[text()='Purchase']";
	String getpurchasedetails_xpath = "//p[@class='lead text-muted ']";
	String purchasecompleted_xpath = "//button[text()='OK']";
	String logout_linkText = "Log out";
	

}
