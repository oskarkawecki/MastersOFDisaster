package app;

import org.apache.commons.cli.ParseException;

import services.ExcelReader;
import services.PrintSecondReport;
import view.UI;

public class App {

    public static void main(String[] args) throws ParseException {
        UI.parsearguments(args);
    }

}
