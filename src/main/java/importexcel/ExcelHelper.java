package importexcel;

import evaluation.PrimeNumber;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelHelper {

    private final PrimeNumber primeNumber;

    public ExcelHelper() {
        primeNumber = new PrimeNumber();
    }

    public void readExcel(String argument) {
        try (FileInputStream fis = new FileInputStream(argument); XSSFWorkbook wb = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getRowIndex() != 0 && !cell.getStringCellValue().isEmpty()) {
                        Long number = Long.parseLong(cell.getStringCellValue());
                        if (number > 1 && primeNumber.isPrime(number)) {
                            System.out.println(number);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
