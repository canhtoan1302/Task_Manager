/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_manager;

/**
 *
 * @author dell
 */
public class Task {

    private int id;
    private String name;
    private int typeID;
    private String date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String name, int typeID, String date, double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.name = name;
        this.typeID = typeID;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaskID(int typeID) {
        this.typeID = typeID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTypeID() {
        return typeID;
    }

    public String getDate() {
        return date;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public String getTypeName() {
        switch (typeID) {
            case 1: {
                return "Code";
            }
            case 2: {
                return "Test";
            }
            case 3: {
                return "Design";
            }
            case 4: {
                return "Review";
            }
        }
        return null;
    }

    public void display() {
        System.out.printf("%-10d%-30s%-15s%-15s%-10.1f%-15s%-15s\n",
                id, name, getTypeName(), date, (to - from), assignee, reviewer);
    }

}
