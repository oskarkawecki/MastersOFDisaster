package app;

import org.apache.commons.cli.ParseException;

import services.ExcelReader;
import services.PrintSecondReport;
import view.UI;

public class App {

    public static void main(String[] args) throws ParseException {

        String path = "src/main/resources/reporter-dane";
        PrintSecondReport.printReport2(ExcelReader.company(path));
        UI.parsearguments(args);
    }

}
