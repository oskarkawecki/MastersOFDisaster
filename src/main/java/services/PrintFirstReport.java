package services;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PrintFirstReport {

    public static void printSheetNames(Workbook wb){
        System.out.println("The given workbook contains the following sheets:");
        for (Sheet sheet : wb) {
            System.out.println(sheet.getSheetName());
        }
    }
    
}
