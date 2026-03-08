package com.excelrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ReadExcelData;

public class Test_Excel {
	
public static void main(String[] args)  {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com/");
		
		String input = ReadExcelData.getParticularCellData(5, 0);
		
		driver.findElement
		(By.xpath("//input[@name='search_query']")).sendKeys(input);
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		
			
		/*driver.findElement(By.name("email")).sendKeys(userName);
		
		String passWord = ReadExcelData.getParticularCellData(1, 1);
		
		driver.findElement(By.name("pass")).sendKeys(passWord);*/
		
		
	}

}
