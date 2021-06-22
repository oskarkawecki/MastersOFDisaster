package services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import model.Company;
import model.Employee;
import model.Project;
import model.Task;
import view.UI;

public class PrintReport {

    private static HashMap<String, Double> timeSheet = new HashMap<String, Double>();
    private static HashMap<String, HashMap<String, Double>> employeeTimeSheet = new HashMap<String, HashMap<String, Double>>();

    public static void printFirstReport(Company company, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        LocalDate sampleDate = LocalDate.parse(UI.sampleDate, formatter);

        ArrayList<Employee> workers = company.getCompanyWorkers();
        for (Employee worker : workers) {
            for (Project project : worker.getProjects()) {
                double projectTotalHours = 0;
                for (Task task : project.getTasks()) {
                    if (task.getDate().isBefore(localDate)) {
                        continue;
                    } else {
                        double hours = task.getHours();
                        projectTotalHours += hours;
                    }
                }
                if (timeSheet.containsKey(project.getName())) {
                    timeSheet.put(project.getName(), timeSheet.get(project.getName()) + projectTotalHours);
                } else {
                    timeSheet.put(project.getName(), projectTotalHours);
                }
            }
        }

        Collections.sort(ExcelReader.reportsDateRange);
        ExcelReader.dateMin = ExcelReader.reportsDateRange.get(0);
        ExcelReader.dateMax = ExcelReader.reportsDateRange.get(ExcelReader.reportsDateRange.size() - 1);

        if (localDate.isAfter(sampleDate)) {
            System.out.println(
                    "Raport przedstawia zakres od: " + localDate.toString() + " do:" + ExcelReader.dateMax.toString());
        } else {
            System.out.println("Raport przedstawia zakres od: " + ExcelReader.dateMin.toString() + " do: "
                    + ExcelReader.dateMax.toString());
        }

        if (timeSheet.isEmpty()) {
            System.out.println("Brak danych do wy�wietlenia - sprawdz katalog");
        } else {
            System.out.println("--- RAPORT 1 ---");
            for (String projectName : timeSheet.keySet()) {
                System.out.println("|" + projectName + "|" + " " + timeSheet.get(projectName) + " |");
            }
        }
        timeSheet.clear();
        System.out.println();
    }

    public static void printSecondReport(Company company, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        LocalDate sampleDate = LocalDate.parse(UI.sampleDate, formatter);

        ArrayList<Employee> workers = company.getCompanyWorkers();
        for (Employee worker : workers) {
            HashMap<String, Double> timeSheet = new HashMap<String, Double>();
            for (Project project : worker.getProjects()) {
                double projectTotalHours = 0;
                for (Task task : project.getTasks()) {
                    if (task.getDate().isBefore(localDate)) {
                        continue;
                    } else {
                        double hours = task.getHours();
                        projectTotalHours += hours;
                    }
                }
                if (employeeTimeSheet.containsKey(worker.getName())) {
                    if (employeeTimeSheet.get(worker.getName()).containsKey(project.getName())) {
                        employeeTimeSheet.get(worker.getName()).put(project.getName(), employeeTimeSheet.get(worker.getName()).get(project.getName()) + projectTotalHours);
                    } else {
                        timeSheet.put(project.getName(), projectTotalHours);
                        employeeTimeSheet.put(worker.getName(), timeSheet);
                    }
                } else {
                    timeSheet.put(project.getName(), projectTotalHours);
                    employeeTimeSheet.put(worker.getName(), timeSheet);
                }
            }
        }

        Collections.sort(ExcelReader.reportsDateRange);
        ExcelReader.dateMin = ExcelReader.reportsDateRange.get(0);
        ExcelReader.dateMax = ExcelReader.reportsDateRange.get(ExcelReader.reportsDateRange.size() - 1);

        if (localDate.isAfter(sampleDate)) {
            System.out.println(
                    "Raport przedstawia zakres od: " + localDate.toString() + " do:" + ExcelReader.dateMax.toString());
        } else {
            System.out.println("Raport przedstawia zakres od: " + ExcelReader.dateMin.toString() + " do: "
                    + ExcelReader.dateMax.toString());
        }

        if (employeeTimeSheet.isEmpty()) {
            System.out.println("Brak danych do wyświetlenia - sprawdz katalog");
        } else {
            System.out.println("--- RAPORT 2 ---");

            for (String employeeName : employeeTimeSheet.keySet()) {
                System.out.print("|Osoba" + "\t".repeat(2) + "|");
                for (String projectName : employeeTimeSheet.get(employeeName).keySet()) {
                    System.out.print(projectName + "\t|");
                }
                System.out.println();
                System.out.print(employeeName + "\t");
                for (String projectName : employeeTimeSheet.get(employeeName).keySet()) {
                    System.out.print(employeeTimeSheet.get(employeeName).get(projectName) + "\t".repeat(2));
                }
                System.out.println();
            }

        }
        timeSheet.clear();
        employeeTimeSheet.clear();
        System.out.println();
    }

}