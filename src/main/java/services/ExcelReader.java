package services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import model.Company;
import model.Employee;
import model.Project;
import model.Task;

public class ExcelReader {

    public static String pathFromCLI;
    public static String fileName;
    public static ArrayList<LocalDate> reportsDateRange = new ArrayList<LocalDate>();
    public static LocalDate dateMin;
    public static LocalDate dateMax;

    public static String getPathFromCLI() {
        return pathFromCLI;
    }

    public static void setPathFromCLI(String pathFromCLI) {
        ExcelReader.pathFromCLI = pathFromCLI;
    }

    public static Workbook openExcelFile(File file) {
        fileName = file.toString();
        try {
            return WorkbookFactory.create(file);
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

    public static Employee readEmployeeFromFile(File file) {

        Employee employee = new Employee();

        ArrayList<Project> projects = ExcelReader.getAllData(ExcelReader.openExcelFile(file));
        for (Project project : projects) {
            employee.addProject(project);
        }
        String employeeName = file.getName().substring(0, file.getName().lastIndexOf('.'));
        employee.setName(employeeName);
        return employee;
    }

    public static ArrayList<Project> getAllData(Workbook wb) {

        Employee employee = new Employee();

        for (Sheet sheet : wb) {
            Project project = new Project();
            project.setName(sheet.getSheetName());

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                if (sheet.getRow(i).getCell(0) == null || sheet.getRow(i).getCell(1) == null
                        || sheet.getRow(i).getCell(2) == null) {
                    System.out.print("Uwaga: wiersz o numerze " + (i+1) + " zostal pominiety w pliku: ");
                    System.out.println(fileName + " w projekcie " + sheet.getSheetName());
                    continue;
                } else {
                    LocalDate date = null;
                    String name;
                    double hours = 0;
                    try {
                        date = convertToLocalDateViaInstant(sheet.getRow(i).getCell(0).getDateCellValue());
                    } catch (Exception e) {
                        System.out.print("Uwaga: wiersz o numerze " + (i+1) + " zostal pominiety w pliku: ");
                        System.out.println(
                                fileName + " w projekcie " + sheet.getSheetName() + ". Niepoprawny format daty");
                        continue;
                    }
                    try {
                        name = sheet.getRow(i).getCell(1).getStringCellValue();
                    } catch (Exception e) {
                        System.out.print("Uwaga: wiersz o numerze " + (i+1) + " zostal pominiety w pliku: ");
                        System.out.println(
                                fileName + " w projekcie " + sheet.getSheetName() + ". Niepoprawna nazwa zadania");
                        continue;
                    }
                    try {
                        hours = (double) sheet.getRow(i).getCell(2).getNumericCellValue();
                    } catch (Exception e) {
                        System.out.print("Uwaga: wiersz o numerze " + (i+1) + " zostal pominiety w pliku: ");
                        System.out.println(
                                fileName + " w projekcie " + sheet.getSheetName() + ". Niepoprawna liczba godzin");
                        continue;
                    }
                    Task task = new Task(date, name, hours);
                    project.addTask(task);
                    reportsDateRange.add(date);
                }
            }
            employee.addProject(project);
        }
        return employee.getProjects();
    }

    public static Company company(String path) {

        ArrayList<String> filesPaths = FindFiles.getFiles(path);
        Company company = new Company();

        for (String file : filesPaths) {
            company.addEmployee(ExcelReader.readEmployeeFromFile(new File(file)));
        }
        filesPaths.clear();
        return company;
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}