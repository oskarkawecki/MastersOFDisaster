package app;

import org.apache.commons.cli.ParseException;

import model.Company;
import services.ExcelReader;
import services.PrintFirstReport;

public class App {

    public static String path = "src/main/resources/reporter-dane/2012/02";
    public static String path2 = "src/main/resources/reporter-dane/2012/01/Nowak_Piotr.xls";

    public static void main(String[] args) throws ParseException {

        Company company = ExcelReader.company(path);
        PrintFirstReport.printReport1(company);

    }
}
