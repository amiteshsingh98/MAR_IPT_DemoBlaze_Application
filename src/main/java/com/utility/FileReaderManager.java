package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {

	private static FileInputStream fileInputStream;
	private static Properties property;

	public static void setDataProperty() throws IOException {
		File file = new File(
				"C:\\Users\\amite\\eclipse-workspace\\Maven_Project\\src\\main\\resources\\TestData.properties");
		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR: OCCURS DURING LOADING THE FILE");
		}catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING READING THE FILE");
		}
	}
	
	
	public static String getDataProperty(String value) throws IOException {
		setDataProperty();
		String data = property.getProperty(value);
		return data;		
	}
	


}
