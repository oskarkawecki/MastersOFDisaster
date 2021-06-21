package app;

import org.apache.commons.cli.ParseException;

import services.ExcelReader;
import services.PrintReport;
import view.UI;

public class App {

    public static void main(String[] args) throws ParseException {


//        String path = "src/main/resources/reporter-dane";
//        String date = "01/01/1900";
//        PrintReport.printSecondReport(ExcelReader.company(path), date);

        UI.parsearguments(args);
    }

}
