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

import model.Employee;
import model.Project;
import model.Task;

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

    public static ArrayList<Project> getAllData(Workbook wb) {
      
        Employee employee = new Employee();

        for (Sheet sheet : wb) {
            Project project = new Project();
            project.setName(sheet.getSheetName());

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {

                LocalDate date = convertToLocalDateViaInstant(sheet.getRow(i).getCell(0).getDateCellValue());
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
                double hours = (double) sheet.getRow(i).getCell(2).getNumericCellValue();
                Task task = new Task(date, name, hours);
                project.addTask(task);
            }
            employee.addProject(project);
        }
        return employee.getProjects();
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}