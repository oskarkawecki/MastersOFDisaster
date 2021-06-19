package services;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    public static Workbook openExcelFile() {
        try {
            return WorkbookFactory.create(new File("src/main/resources/reporter-dane/2012/01/Kowalski_Jan.xls"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}