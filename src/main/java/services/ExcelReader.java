package services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
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

    public static List<String> readProjectNames(Workbook wb) {
        List<String> projects = new ArrayList<String>();
        for (Sheet sheet : wb) {
            projects.add(sheet.getSheetName());
        }

        return projects;
    }

    public static void getTaskFromSheet(Workbook wb) {

        DataFormatter formatter = new DataFormatter();

        for (Sheet sheet : wb) {
            System.out.println(String.format("The content of %s sheets:", sheet.getSheetName()));

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {

//                Date date = (Date) sheet.getRow(i).getCell(0);
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
                double hours = (double) sheet.getRow(i).getCell(2).getNumericCellValue();

                System.out.println(name + " " + hours);
            }
        }
    }
}