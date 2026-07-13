package utilties;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReaderAdvance {
Workbook workbook; //Workbook variableDeclared at class level so all methods can use it.
Sheet sheet;// Sheet variable
public ExcelReaderAdvance() throws Exception //Constructor.automatically call ExcelReaderAdvance er = new ExcelReaderAdvance();
    {
        FileInputStream fis =
                new FileInputStream("src/test/resources/LoginData.xlsx");// Open Excel file only ONCE
      workbook = new XSSFWorkbook(fis);// Load workbook
      sheet = workbook.getSheet("Login");// Open Login sheet
    }
public String[] getLoginData(int rowNumber) //Read one row from Excel
    {
        Row row = sheet.getRow(rowNumber);// Go to required row
        String data[] = new String[2];// Store Username & Password
       if(row.getCell(0)==null)  // Username
            data[0]="";
        else
            data[0]=row.getCell(0).toString();
            if(row.getCell(1)==null) // Password
            data[1]="";
        else
            data[1]=row.getCell(1).toString();
        return data;// Return both values
    }

 public void closeWorkbook() throws Exception //Close Workbook
    {
        workbook.close();
    }}
