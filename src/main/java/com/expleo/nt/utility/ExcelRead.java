package com.expleo.nt.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	
	public static final String Excelfileloaction="C:\\Users\\ALM.TGS-DPC-2394\\workspace\\"
			+ "NTBDD\\src\\main\\java\\com\\expleo\\nt\\utility\\Data.xlsx";

	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;

	public static void loadexcel()
	{
	System.out.println("load excel");

	File file =new File(Excelfileloaction);
	try {
		fis = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	try {
		workbook= new XSSFWorkbook(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sheet = workbook.getSheet("TestData");
	try {
		fis.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	public static Map<String, Map<String,String>> getDataMap() throws Exception {
		if (sheet==null){
			loadexcel();
		}
	Map<String, Map<String,String>> superMap = new HashMap<String,Map<String,String>>();
	Map<String,String> myMap= new HashMap <String,String>();{
	 
	for (int i=1; i<sheet.getLastRowNum()+1;i++)
	{

	row=sheet.getRow(i);
	String KeyCell = row.getCell(0).getStringCellValue();
	
	int ColNum=row.getLastCellNum();
	for(int j=1; j<ColNum;j++){
		String value= row.getCell(j).getStringCellValue();
		myMap.put(KeyCell,value);
	}
	
	superMap.put("MASTERDATA",myMap);
	}
	return superMap;
	
	}}

	public static String getValue(String Key) throws Exception{
		Map<String,String> myVal = getDataMap().get("MASTERDATA");
		String retValue = myVal.get(Key);
		return retValue;
		}
	
	
	
	}
