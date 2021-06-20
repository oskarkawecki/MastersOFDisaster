package model;

import java.util.ArrayList;

public class Company {

    ArrayList<Employee> companyWorkers = new ArrayList<Employee>();

    public ArrayList<Employee> getCompanyWorkers() {
        return companyWorkers;
    }

    public void setCompanyWorkers(ArrayList<Employee> companyWorkers) {
        this.companyWorkers = companyWorkers;
    }

    public void addEmployee(Employee employee) {
        this.companyWorkers.add(employee);
    }

}
