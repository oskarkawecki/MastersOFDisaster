package app;

import org.apache.commons.cli.ParseException;

import view.UI;
import org.apache.poi.ss.usermodel.Workbook;

import services.ExcelReader;

public class App {

    public static void main(String[] args) throws ParseException {
        System.out.println("Hello team");

        UI.parsearguments(args);

        Workbook example1 = ExcelReader.openExcelFile();

        ExcelReader.getTaskFromSheet(example1);
    }
}
