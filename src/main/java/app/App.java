package app;

import org.apache.poi.ss.usermodel.Workbook;

import services.ExcelReader;
import services.PrintFirstReport;

public class App {

    public static void main(String[] args) {
        
        Workbook example1 = ExcelReader.openExcelFile();
        
        PrintFirstReport.printSheetNames(example1);
        
    }

}
