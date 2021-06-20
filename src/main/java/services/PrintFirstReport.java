package services;

import java.util.ArrayList;
import java.util.HashMap;

import model.Company;
import model.Employee;
import model.Project;
import model.Task;

public class PrintFirstReport {

    private static HashMap<String, Double> timeSheet = new HashMap<String, Double>();

    public static void printReport1(Company company, int year) {

        ArrayList<Employee> workers = company.getCompanyWorkers();
        for (Employee worker : workers) {
            for (Project project : worker.getProjects()) {
                double projectTotalHours = 0;
                for (Task task : project.getTasks()) {
                    double hours = task.getHours();
                    projectTotalHours += hours;
                }
                timeSheet.put(project.getName(), projectTotalHours);
            }
        }
        
        System.out.println("Raport1");
        for (Object objectName : timeSheet.keySet()) {
            System.out.println("|" + objectName + "|" + " " + timeSheet.get(objectName) + " |");
        }

    }

}