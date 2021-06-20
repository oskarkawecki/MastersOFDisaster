package model;

import java.util.ArrayList;

public class Employee {

    private String name;

    ArrayList<Project> projects = new ArrayList<Project>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }
    
}