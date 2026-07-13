package utilties;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {
	// This method reads one row from Excel.
    // Example:
    // getLoginData(1) -> Blank Login
    // getLoginData(2) -> Without Password
    // getLoginData(3) -> Valid Login

    public String[] getLoginData(int rowNumber) throws Exception {

        // Open Excel file
        FileInputStream fis = new FileInputStream(
                "src/test/resources/LoginData.xlsx");
    // Create Workbook object
        Workbook workbook = new XSSFWorkbook(fis);

        // Open Login sheet
        Sheet sheet = workbook.getSheet("Login");

       
          Row row = sheet.getRow(rowNumber); // Read required row
     
        String[] data = new String[2];// String array to store Username and Password

        // Read Username
        if(row.getCell(0)==null)
            data[0]="";
        else
            data[0]=row.getCell(0).toString();

        // Read Password
        if(row.getCell(1)==null)
            data[1]="";
        else
            data[1]=row.getCell(1).toString();
        workbook.close();
        fis.close();

        // Return Username and Password
        return data;
    }

}
