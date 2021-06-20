package app;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.commons.cli.ParseException;
import org.apache.poi.ss.usermodel.Workbook;

import model.Company;
import model.Employee;
import model.Project;
import model.Task;
import services.ExcelReader;
import services.PrintFirstReport;
import view.UI;

public class App {

    public static void main(String[] args) throws ParseException {

//      Dane do testu modelu

        Company company = new Company();
        Employee employee = new Employee();
        
        ArrayList<Project> projects = ExcelReader.getAllData(ExcelReader.openExcelFile());
        for(Project project : projects){
            employee.addProject(project);
        }
        employee.setName("Adam Mickiewicz");
        company.addEmployee(employee);
        
        PrintFirstReport.printReport1(company, 2012);
        
//        UI.parsearguments(args);

    }
}
