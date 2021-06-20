package app;

import java.io.File;

import org.apache.commons.cli.ParseException;

import model.Company;
import services.ExcelReader;
import services.PrintFirstReport;

public class App {

    public static String path = "src/main/resources/reporter-dane/2012/01/Kowalski_Jan.xls";
    public static String path2 = "src/main/resources/reporter-dane/2012/01/Nowak_Piotr.xls";

    public static void main(String[] args) throws ParseException {

        Company company = new Company();

        company.addEmployee(ExcelReader.readEmployeeFromFile(new File(path)));
        company.addEmployee(ExcelReader.readEmployeeFromFile(new File(path2)));

        PrintFirstReport.printReport1(company, 2012);

//        UI.parsearguments(args);

    }
}
