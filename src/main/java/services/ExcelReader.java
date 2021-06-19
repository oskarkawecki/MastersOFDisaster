package services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    public static String path = "src/main/resources/reporter-dane/2012/01/Kowalski_Jan.xls";

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

        for (Sheet sheet : wb) {
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {

                LocalDate date = convertToLocalDateViaInstant(sheet.getRow(i).getCell(0).getDateCellValue());
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
                double hours = (double) sheet.getRow(i).getCell(2).getNumericCellValue();

            }
        }
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}