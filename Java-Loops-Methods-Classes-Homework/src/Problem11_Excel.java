import java.io.*;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*	You can download only required libraries form:
		http://dox.bg/files/dw?a=b69d6883b5 
	Or from official site http://poi.apache.org/download.html#POI-3.10-FINAL
		dom4j-1.6.1.jar
		poi-3.10-FINAL-20140208.jar
		poi-ooxml-3.10-FINAL-20140208.jar
		poi-ooxml-schemas-3.10-FINAL-20140208.jar
		xmlbeans-2.3.0.jar */
class Problem11_Excel {
	public static TreeMap<String, BigDecimal> office = new TreeMap<>();

	public static TreeMap<String, BigDecimal> readXlsx(File inputFile,
			TreeMap<String, BigDecimal> office) {
		try {
			// Get the workbook instance for XLSX file
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));

			// Get first sheet from the workbook
			XSSFSheet sheet = wb.getSheetAt(0);
			// sheet = wb.getSheet("Incomes");
			Row row;
			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				String officeName = row.getCell(0).getStringCellValue();
				String totalIncomeString = String.valueOf(row.getCell(5)
						.getNumericCellValue());
				BigDecimal totalIncome = new BigDecimal(totalIncomeString);

				if (office.containsKey(officeName)) {
					office.put(officeName,
							office.get(officeName).add(totalIncome));

				} else {
					office.put(officeName, totalIncome);
				}
			}
		} catch (Exception e) {
			System.err.println("Exception :" + e.getMessage());
		}
		return office;
	}

	public static void main(String[] args) {

		File inputFile = new File(
				"./Problem11_inputExcel/3. Incomes-Report.xlsx");
		readXlsx(inputFile, office);
		BigDecimal grandTotal = BigDecimal.ZERO;

		for (String key : office.keySet()) {
			System.out.printf("%s Total -> %.2f\n", key, office.get(key));
			grandTotal = grandTotal.add(office.get(key));
		}
		System.out.printf("Grand Total -> %.2f", grandTotal);
	}
}