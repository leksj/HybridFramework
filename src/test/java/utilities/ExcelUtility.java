package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public  FileInputStream fi;
	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  XSSFCellStyle cellStyle;
	public  FileOutputStream fo;
	String xlFile;



	public ExcelUtility(String xlFile) {

		this.xlFile=xlFile;
	}

	public int getRowCount(String xlSheet) throws IOException 
	{
		fi = new FileInputStream(xlFile);
		workbook= new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);

		int noOfRows=sheet.getLastRowNum();

		workbook.close();
		fi.close();

		return noOfRows;
	}

	public int getCellCount(String xlSheet,int rowNum) throws IOException 
	{
		fi = new FileInputStream(xlFile);
		workbook= new XSSFWorkbook(fi); 
		sheet = workbook.getSheet(xlSheet);

		int noOfColumns=sheet.getRow(rowNum).getLastCellNum();

		workbook.close();
		fi.close();

		return noOfColumns;
	}

	public String getCellData(String xlSheet,int rowNum,int colNum) throws IOException 
	{
		fi = new FileInputStream(xlFile);
		workbook= new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);

		String data;
		try {
			//data=sheet.getRow(rowNum).getCell(colNum).toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		} catch (Exception e) {

			data="";
		}

		workbook.close();
		fi.close();


		return data;
	}


	public void setCellData(String xlSheet,int rowNum,int colNum,String data) throws IOException {

		fi = new FileInputStream(xlFile);
		workbook= new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);

		row=sheet.getRow(rowNum);

		//if the row is empty then it cannot create a cell on the emplty row.so need to create the row1st and then create cell and write
		if (row==null) 
		{
			System.out.println("The row is empty");
			row=sheet.createRow(rowNum);
			row.createCell(colNum).setCellValue(data);
		}
		else 
		{
			row.createCell(colNum).setCellValue(data);
		}


		fo= new FileOutputStream(xlFile);
		workbook.write(fo);

		workbook.close();
		fi.close();
		fo.close();


	}

	public void fillGreenColor(String xlSheet,int rowNum,int colNum) throws IOException {

		fi = new FileInputStream(xlFile);
		workbook= new XSSFWorkbook(fi);
		sheet = workbook.getSheet("sheet1");

		row=sheet.getRow(rowNum);

		if (row==null) 
		{
			row=sheet.createRow(rowNum);
		}
		cell= row.getCell(colNum);
		if (cell==null) {
			cell=row.createCell(colNum);
		}

		cellStyle = workbook.createCellStyle();

		cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(cellStyle);

		fo= new FileOutputStream(xlFile);
		workbook.write(fo);

		workbook.close();
		fi.close();
		fo.close();

	}

	public void fillRedColor(String xlSheet,int rowNum,int colNum) throws IOException {

		fi = new FileInputStream(xlFile);
		workbook= new XSSFWorkbook(fi);
		sheet = workbook.getSheet("sheet1");

		row=sheet.getRow(rowNum);
		if (row==null) 
		{
			row=sheet.createRow(rowNum);
		}

		cell= row.getCell(colNum);
		if (cell==null) {
			cell=row.createCell(colNum);
		}

		cellStyle = workbook.createCellStyle();

		cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(cellStyle);

		fo= new FileOutputStream(xlFile);
		workbook.write(fo);

		workbook.close();
		fi.close();
		fo.close();

	}





}
