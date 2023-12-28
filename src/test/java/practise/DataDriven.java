package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\user1\\OneDrive\\Documents\\SampleTestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		ArrayList<String> a = new ArrayList<String>();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet desiredSheet = workbook.getSheetAt(i);

				Iterator<Row> rows = desiredSheet.rowIterator();
				Row specificRow = rows.next();
				Iterator<Cell> columns = specificRow.cellIterator();

				int count = 0;
				int columnCount = 0;
				while (columns.hasNext()) {
					Cell specifcColumn = columns.next();
					if (specifcColumn.getStringCellValue().equalsIgnoreCase("TestCases")) {
						columnCount = count;
					}
					count++;
				}

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(columnCount).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cb = r.cellIterator();
						while (cb.hasNext()) {
							Cell c = cb.next();
							if (c.getCellType() == CellType.STRING)
								a.add(c.getStringCellValue());
							else
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}
				}
			}
		}
		return a;
	}

}
