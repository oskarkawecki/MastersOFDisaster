package app;

import java.time.LocalDate;

import org.apache.commons.cli.ParseException;
import org.apache.poi.ss.usermodel.Workbook;

import model.Company;
import model.Employee;
import model.Project;
import model.Task;
import services.ExcelReader;
import view.UI;

public class App {

    public static void main(String[] args) throws ParseException {

//      Dane do testu modelu

        Company company = new Company();
        Employee employee = new Employee();
        employee.setName("Adam Mickiewicz");
        company.addEmployee(employee);

        Project project = new Project();
        project.setName("Trasa kaszubska");
        Task task = new Task();
        task.setName("Analiza wymagan");
        task.setHours(25);
        LocalDate date = LocalDate.of(2018, 11, 5);
        task.setDate(date);
        employee.addProject(project);
        project.addTask(task);
        
        
        

        UI.parsearguments(args);

        Workbook example1 = ExcelReader.openExcelFile();

        ExcelReader.getTaskFromSheet(example1);
    }
}
