package com.rodarte.crm.repository;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rodarte.crm.model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadXLSX {
	
	public ReadXLSX() throws IOException
	{
		
	}
	
	public List<Student>  ReadXLSXFile(String location) throws IOException 
	{
		
		List<Student> allStudents = new ArrayList<Student>();
		File file = new File(location);   
		
		FileInputStream fis = new FileInputStream(file);
		
		try (//creating Workbook instance that refers to .xlsx file
				
			XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			
			//get the first sheet
			XSSFSheet sheet = wb.getSheetAt(0);     
			
			 //iterating over rows in  excel file  
			Iterator<Row> itr = sheet.iterator();   
			
			//iterates over all rows on worksheet 0
			int rowNumber = 0;
			while (itr.hasNext())                 
			{
				Row row;
			    // skip header
				if(rowNumber == 0)
				{
					row = itr.next();
					// System.out.println("$$$$$$*****");
					rowNumber++;
					continue;
				}
				
				//each line of sheets
				row = itr.next();
				
				//iterating over each column(cells)
				Iterator<Cell> cellIterator = row.cellIterator(); 
				
				while (cellIterator.hasNext())
				{
					Cell cell;
					Student student = new Student();
					
					cell = cellIterator.next();
					// System.out.println(" #### AQUI PASSOU ####" + cell.toString());
									
					student.setId((long) cell.getNumericCellValue());
					
					cell = cellIterator.next();
					student.setName(cell.getStringCellValue());
					
					cell = cellIterator.next();
					student.setGender(cell.getStringCellValue());
					
					cell = cellIterator.next();
					student.setBirthday(cell.getDateCellValue());
					
					cell = cellIterator.next();
					student.setFirstGrade(cell.getNumericCellValue());
					
					cell = cellIterator.next();
					student.setSecondGrade(cell.getNumericCellValue());
					
					cell = cellIterator.next();
					student.setThirdGrade(cell.getNumericCellValue());
					
					allStudents.add(student);
									
				}
			}
			return allStudents;
		}

	}
}
