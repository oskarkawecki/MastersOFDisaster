package model;

import java.time.LocalDate;

public class Task {
    private String name;
    private LocalDate date;
    private double hours;

    public Task() {
    }

    public Task(LocalDate date, String name, double hours) {
        this.date = date;
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
}