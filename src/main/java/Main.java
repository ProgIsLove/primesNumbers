import importexcel.ExcelHelper;

public class Main {

    public static void main(String[] args) {
        ExcelHelper excel = new ExcelHelper();
        excel.readExcel(args[0]);
    }
}
