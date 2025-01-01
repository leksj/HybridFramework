package utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviders {
	
	@DataProvider(name="loginData", indices= {0,1})
	public String[][] loginData() throws IOException
	{
		
		
		String path=".\\testData\\LoginData.xlsx"; //taking excel from testdata folder
		
		ExcelUtility xlutil= new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totlaColumns=xlutil.getCellCount("sheet1", 0);
		
		System.out.println(totalrows);
		System.out.println(totlaColumns);
		
		String loginData[][]=new String[totalrows][totlaColumns];
		
		for (int r = 1; r <=totalrows; r++) {
			
			for (int c = 0; c < totlaColumns; c++) {
				
				loginData[r-1][c]=xlutil.getCellData("sheet1", r, c);
			}
			
		}
		
//		for (String[] strings : loginData) {
//			System.out.println(Arrays.toString(strings));
//		}
//		
//		System.out.println();
		return loginData;
		
	}

}
