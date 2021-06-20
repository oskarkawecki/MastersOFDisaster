package services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import model.Company;
import model.Employee;
import model.Project;
import model.Task;

public class PrintSecondReport {

    private static HashMap<String, HashMap<String, Double>> employeeTimeSheet = new HashMap<String, HashMap<String, Double>>();

    public static void printReport2(Company company) {

        ArrayList<Employee> workers = company.getCompanyWorkers();
        for (Employee worker : workers) {
            HashMap<String, Double> timeSheet = new HashMap<String, Double>();
            for (Project project : worker.getProjects()) {
                double projectTotalHours = 0;
                for (Task task : project.getTasks()) {
                    double hours = task.getHours();
                    projectTotalHours += hours;
                }

                // Jeœli employeeTimeSheet zawiera pracownika
                if (employeeTimeSheet.containsKey(worker.getName())) {
                    // Jeœli timeSheet pracownika zawiera projekt
                    if (employeeTimeSheet.get(worker.getName()).containsKey(project.getName())) {
                        // Zast¹p czas przepracowany na tym projekcie: obecnym czasem + dodatkowym
                        // wyliczonym teraz
                        timeSheet.put(project.getName(),
                                employeeTimeSheet.get(worker.getName()).get(project.getName()) + projectTotalHours);
                        employeeTimeSheet.put(worker.getName(), timeSheet);
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

        if (employeeTimeSheet.isEmpty()) {
            System.out.println("Brak danych do wyœwietlenia - sprawdz katalog");
        } else {
            System.out.println("--- RAPORT 2 ---");
            for (String employeeName : employeeTimeSheet.keySet()) {
                System.out.println(employeeName);
                for (String projectName : employeeTimeSheet.get(employeeName).keySet()) {
                    System.out.println("|" + projectName + "|" + " "
                            + employeeTimeSheet.get(employeeName).get(projectName) + " |");
                }
            }

        }
    }

    public static void printReport2From(Company company, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

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
                // Jeœli employeeTimeSheet zawiera pracownika
                if (employeeTimeSheet.containsKey(worker.getName())) {
                    // Jeœli timeSheet pracownika zawiera projekt
                    if (employeeTimeSheet.get(worker.getName()).containsKey(project.getName())) {
                        // Zast¹p czas przepracowany na tym projekcie: obecnym czasem + dodatkowym
                        // wyliczonym teraz
                        timeSheet.put(project.getName(),
                                employeeTimeSheet.get(worker.getName()).get(project.getName()) + projectTotalHours);
                        employeeTimeSheet.put(worker.getName(), timeSheet);
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

        if (employeeTimeSheet.isEmpty()) {
            System.out.println("Brak danych do wyœwietlenia - sprawdz katalog");
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
    }

}
