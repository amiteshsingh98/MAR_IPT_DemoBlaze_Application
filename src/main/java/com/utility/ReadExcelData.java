package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public static String getParticularCellData(int rowValue, int columnValue) {

		String data = null;

		try {
			File file = new File("C:\\Users\\amite\\Downloads\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.getRow(rowValue);
			Cell cell = row.getCell(columnValue);
			// String data = cell.getStringCellValue();
			// Dataformatter--> covert every cell into string
			DataFormatter dataFormat = new DataFormatter();
			data = dataFormat.formatCellValue(cell);
			// System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public static void readAllData() {
		try {
			File file = new File("C:\\Users\\amite\\Downloads\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");

			int lastRowNum = sheet.getLastRowNum();
			System.out.println("No. of rows: " + lastRowNum);

			short lastCellNum = sheet.getRow(0).getLastCellNum();
			System.out.println("No. of columns: " + lastCellNum);

			// for (int i = 0; i < lastRowNum; i++)--with header
			// for (int i = 1; i < lastRowNum; i++)--without header
			for (int i = 1; i <= lastRowNum; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < lastCellNum; j++) {
					Cell cell = row.getCell(j);
					DataFormatter dataFormat = new DataFormatter();
					String data = dataFormat.formatCellValue(cell);
					System.out.println(data);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void writeData() {
		try {
			File file = new File("C:\\Users\\amite\\Downloads\\DataDriven_IPT.xlsx");
			FileInputStream fileInput = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(fileInput);

		    book.createSheet("MARIPT2026").createRow(0).createCell(0).setCellValue("Raju");
			book.getSheet("MARIPT2026").createRow(1).createCell(0).setCellValue("Renu");
			FileOutputStream fileOut = new FileOutputStream(file);
			book.write(fileOut);
			book.close();
			System.out.println("Sheet created and data written successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		// String particularCellData = getParticularCellData(3,2);
		// System.out.println(particularCellData);
		// readAllData();
		writeData();

	}

}
