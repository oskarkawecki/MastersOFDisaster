package model;

import java.util.ArrayList;

public class Project {
    private String name;
    private double time;

    ArrayList<Task> tasks = new ArrayList<Task>();

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

}