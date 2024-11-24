package Data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingFromExcelSheet {
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ReadingFromExcelSheet() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/data/Register Data.xlsx";
        String sheetName = "Sheet1";
        FileInputStream fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(int row, int col) {
        Row sheetRow = sheet.getRow(row);
        Cell cell = sheetRow.getCell(col);
        return cell.toString();
    }

    public int getNumOfRows() {
        return sheet.getPhysicalNumberOfRows();
    }

}
