package com.plutora.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.io.Zip;

import com.plutora.constants.CommonConstants;

public class FolderManagementUtilLib {

	/***
	 * Delete files from folder 
	 */
	public static void deleteFilesFromFolder(String filePath) {
		final File folder = new File(filePath);
		if(folder.exists()){
		for (File file : folder.listFiles()) {
			if (file.getName().endsWith(".png")) {
				file.delete();
				System.out.println(file + " ....removed.");
			}
			if (file.getName().endsWith(".html")) {
				file.delete();
				System.out.println(file + " ....removed.");
			}
			if (file.getName().endsWith(".xlsx")) {
				file.delete();
				System.out.println(file + " ....removed.");
			}
			if (file.getName().startsWith("CompressedExtentReports")) {
				file.delete();
				System.out.println(file + " ....removed.");
			}
		}
		}else{
			
		}
		
	}
	
	/**
	 * Get data from excel file */
	 
	public static String getExcelData(String filePath, String sheetName, int rowIndex, int cellIndex) {
		String data = null;
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * Get data from excel file */
	 
	public static String[] getRowData(String filePath, String sheetName, int rowIndex) {
		 String[] headers =null;
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			int noOfColumns = st.getRow(rowIndex).getLastCellNum();
			headers = new String[noOfColumns];
            for (int j=0;j<noOfColumns;j++){
            	headers[j] = st.getRow(rowIndex).getCell(j).getStringCellValue();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return headers;
	}
	
	/**
	 * Set data from excel file 
	 */
	public static void setExcelData(String filePath, String sheetName, int rowIndex, int cellIndex, String data) {
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.createCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generate random string
	 */
	public static String generateRandomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	/**
	 * Create zip file for failed test cases screenshots
	 */
	public static void screenShotZipFile(String filePath) {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File folder = new File(filePath);
		for (File file : folder.listFiles()) {
			if (file.getName().startsWith("ExtentReports")) {
				File fileToStore = file.getAbsoluteFile();
				File filetoCompress = new File(CommonConstants.compressedZipPath+dateFormat.format(new Date()) + ".zip");
				Zip z = new Zip();
//				try {
//					z.zip(fileToStore, filetoCompress);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		}
	}

	/**
	 * Put data object to hash table
	
	public static Object[][] getData(XlsReader xls, String testCaseName, String dataSheetName) {

		Object[][] data = null;

		int testStartRowNum = 1;
		while (!(xls.getCellData(dataSheetName, 0, testStartRowNum).equals(testCaseName))) {
			testStartRowNum++;
		}
		System.out.println("Test starts from row - " + testStartRowNum);
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		// calculate rows of data
		int rows = 0;

		while (!xls.getCellData(dataSheetName, 0, dataStartRowNum + rows).equals("")) {
			if (xls.getCellData(dataSheetName, 0, dataStartRowNum + rows).equals("N")) {
				break;
			}
			rows++;
		}

		System.out.println("Total rows are  - " + rows);

		// calculate total cols
		int cols = 0;
		while (!xls.getCellData(dataSheetName, cols, colStartRowNum).equals("")) {
			cols++;
		}
		System.out.println("Total cols are  - " + cols);
		data = new Object[rows][1];
		// read the data
		int dataRow = 0;
		Hashtable<String, String> table = null;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 1; cNum < cols; cNum++) {
				if (xls.getCellData(dataSheetName, 0, rNum).equals("Y")) {
					String key = xls.getCellData(dataSheetName, cNum, colStartRowNum);
					String value = xls.getCellData(dataSheetName, cNum, rNum);
					table.put(key, value);
				}
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		// reads data for only testCaseName
		return data;
	}*/
	
	public static String getFileName(String filePath, String fileName) {
		String name = null;
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().contains(fileName)) {
					name = listOfFiles[i].getName();
					break;
				}
			}
		}
		return name;
	}
	
	/* Create zip file */
	public static void createZipFile(String filePath, String destFolderPath) throws IOException {
		File directoryToZip = new File(filePath);
		File destFolder = new File(destFolderPath);
		if(!destFolder.exists()){
			destFolder.mkdirs();
		}

		List<File> fileList = new ArrayList<File>();
		//System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
		getAllFiles(directoryToZip, fileList);
		//System.out.println("---Creating zip file");
		writeZipFile(directoryToZip, fileList, destFolder);
		//System.out.println("---Done");
	}
		
	public static void getAllFiles(File dir, List<File> fileList) {
		File[] files = dir.listFiles();
		for (File file : files) {
			fileList.add(file);
			if (file.isDirectory()) {
				//System.out.println("directory:" + file.getCanonicalPath());
				getAllFiles(file, fileList);
			}
		}
	}

	public static void writeZipFile(File directoryToZip, List<File> fileList, File destFolder) {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String fname = destFolder + File.separator + directoryToZip.getName() + " " + dateFormat.format(new Date()) + ".zip";
		try {
			FileOutputStream fos = new FileOutputStream(fname);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}
			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
			IOException {

		FileInputStream fis = new FileInputStream(file);

		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		//System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		zos.closeEntry();
		fis.close();
	}
}
