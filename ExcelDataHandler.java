package ExcelLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataHandler 
{
	String Filename;
	FileInputStream excelFile;
    Workbook workbook;
    Sheet datatypeSheet;
    int AvailableSheetCount;
    List<String> rowdata = null;
	
    public ExcelDataHandler()
    {
        // Initialize all class variables
    	Filename = "";
    	excelFile = null;
    	workbook = null;
    	datatypeSheet = null;
    	AvailableSheetCount= 0;
        //ExcelHandler = new Excel.Application();
        //ExcelWorkbook = null;
    }
    public boolean Initialize(String file)
    {
        Filename = file;       
        try
        {
        	excelFile = new FileInputStream(new File(Filename));
            workbook = new XSSFWorkbook(excelFile);
            AvailableSheetCount = workbook.getNumberOfSheets();
        }
        catch(Exception ex)
        {
            System.out.println("Getting the following exception while trying to build path '" + ex.getMessage() + "'");
            return false;
        }
        return true;

    }
    
    public boolean ReadOneRow(int sheetindex, int rowNo, List <String> data)
    {
    	int rowcount=0;
    	
    	try
    	{    		
    		if(sheetindex < AvailableSheetCount)
    		{
    			datatypeSheet = workbook.getSheetAt(sheetindex);
    		}
    		else
    		{
    			System.out.println("Don't have that many sheets in excel. Exiting");
    			return false;
    		}	    	
	    	
	        Iterator<Row> iterator = datatypeSheet.iterator();       
	        
	        while (iterator.hasNext()) {
	        	Row currentRow = iterator.next();
	        	rowcount++;
	        	if(rowcount == rowNo) //reached the required row
	        	{
	        		Iterator<Cell> cellIterator = currentRow.iterator();
	                while (cellIterator.hasNext()) 
	                {
	                    Cell currentCell = cellIterator.next();     
	                    if (currentCell.getCellTypeEnum() == CellType.STRING) 
	                    {
	                    	data.add( (currentCell.getStringCellValue()).trim() );
	                    } 
	                    else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) 
	                    {
	                    	//data.add(toString(currentCell.get
	                    	double value = currentCell.getNumericCellValue();
	                    	data.add(Double.toString(value));
	                        //System.out.print(currentCell.getNumericCellValue() + "--");
	                    }
	                         
	                }	        		
	        	}
	        	else
	        	{	        		
	        		continue;
	        	}
	        	
	            System.out.println();
	            workbook.close();
	        }
    	}
	    catch (FileNotFoundException e) 
    	{
	            e.printStackTrace();
        } catch (IOException e) 
    	{
	            e.printStackTrace();
        }
    	return true;
    }//End of ReadOneRow
    
    public boolean ReadOneSheet(int sheetindex, List<List<String>> Data)
    {    	
    	try
    	{    		
    		if(sheetindex < AvailableSheetCount)
    		{
    			datatypeSheet = workbook.getSheetAt(sheetindex);
    		}
    		else
    		{
    			System.out.println("Don't have that many sheets in excel. Exiting");
    			return false;
    		}	    	
	    	
	        Iterator<Row> iterator = datatypeSheet.iterator();       
	        
	        while (iterator.hasNext()) 
	        {
	        	Row currentRow = iterator.next();
        		Iterator<Cell> cellIterator = currentRow.iterator();
        		rowdata = new ArrayList<String>();
                while (cellIterator.hasNext()) 
                {
                    Cell currentCell = cellIterator.next();     
                    if (currentCell.getCellTypeEnum() == CellType.STRING) 
                    {
                    	rowdata.add( (currentCell.getStringCellValue()).trim());
                    } 
                    else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) 
                    {
                    	//data.add(toString(currentCell.get
                    	double value = currentCell.getNumericCellValue();
                    	rowdata.add(Double.toString(value));
                        //System.out.print(currentCell.getNumericCellValue() + "--");
                    }	
                         
                }
                Data.add(rowdata);
	        		
	            System.out.println();
	            workbook.close();
	        }
    	}
	    catch (FileNotFoundException e) 
    	{
	            e.printStackTrace();
        } catch (IOException e) 
    	{
	            e.printStackTrace();
        }
    	return true;
    }//End of ReadOneSheet
    
    public boolean WriteOneRow(String SheetName,List <String> data)
    {
    	int rowCount=0;
    	Row row = null;
    	
    	datatypeSheet = workbook.getSheet(SheetName);
    	if(datatypeSheet ==null)
    	{
    		datatypeSheet= workbook.createSheet(SheetName);
    		rowCount = datatypeSheet.getLastRowNum();
    	}
    	else
    	{
    		rowCount = datatypeSheet.getLastRowNum() + 1 ;
    	}
    	
    	try
    	{        	
    		
    		 row = datatypeSheet.createRow(rowCount++);
    		int columnCount = 0;
    		for (int i=0;i<data.size();i++) {     			
                
                 Cell cell = row.createCell(columnCount++);
                 cell.setCellValue((data.get(i)).trim());                      
            }             
             
            try (FileOutputStream outputStream = new FileOutputStream(Filename)) {
                workbook.write(outputStream);
            }
    	}
	    catch (FileNotFoundException e) 
    	{
	            e.printStackTrace();
        } catch (IOException e) 
    	{
	            e.printStackTrace();
        }
    	return true;
    }//End of ReadOneRow

}
