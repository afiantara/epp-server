package bo.inventory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Import {
	public Import()
	{
		
	}
	
	public boolean importHargaJual(String filePath)
	{
		System.out.println("file import: " + filePath);
		return importFile(filePath);
	}
	
	public boolean importFile(String filename)
	{
		  FileInputStream fis = null;
	        try {
	            fis = new FileInputStream(filename);
	            
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            Iterator rows = sheet.rowIterator();
	            int number=sheet.getLastRowNum();
	            System.out.println(" number of rows"+ number);
	            while (rows.hasNext())
	            {
	 
	                XSSFRow row = ((XSSFRow) rows.next());
	                if(row.getRowNum()==0)
	                	continue;
	                Iterator cells = row.cellIterator();
	                while(cells.hasNext())
	                {
	                    XSSFCell cell = (XSSFCell) cells.next();
	                    if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
	                    {
	                    	String Value=cell.getRawValue();
	                    	System.out.println(Value);
	                    }
	                    else
	                    {
	                    	String Value=cell.getStringCellValue();
	                    	System.out.println(Value);
	                    }
	                }
	             }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            if (fis != null) {
	                try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
	            }
	        }
			return false;
	       
	}
	
	public static void main(String[] args)
	{
		Import imp=new Import();
		imp.importFile("D:\\tridaya\\project-erp\\hjual.xlsx");
	}
}
